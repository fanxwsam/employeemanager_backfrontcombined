(function() {
    ("use strict");

    /* Controllers */
    /*
     * There are 2 controllers: employeesController and employeeController
     * employeesController is for the list of employees and responsible for the list display,
     * employee delete and edit
     * employeeController is used to add new employees
     */

    angular
        .module("controllers", [])
        .controller(
            "employeesController",
            function($scope, $location, employees, metawidgetConfig, $http) {
                // Load all employees
                employees.then(function(result) {
                    $scope.employees = result.data;
                });

                $scope.metawidgetConfig = metawidgetConfig;

                // when clicking the delete button for one employee, it will be set value
                $scope.deletedEmp = null;

                // used for opening a window to process deleting, editing...
                $scope.onOpenModal = function(employee, mode) {
                    const container = document.getElementById("main-container");
                    const button = document.createElement("button");
                    button.type = "button";
                    button.style.display = "none";
                    button.setAttribute("data-toggle", "modal");

                    // when the open mode is 'delete', open the 'confirmation' window
                    if (mode === "delete") {
                        // set the value of the employee that will be deleted
                        $scope.deletedEmp = employee;

                        // set the window that will be opened
                        button.setAttribute("data-target", "#deleteEmployeeModal");
                    }

                    // open the cooresponding window
                    container.appendChild(button);
                    button.click();
                };

                // in the opened window, when clicking 'delete', this function will be invoked
                $scope.onDeleteEmployee = function() {
                    // call RestAPI to delete the employee and refresh the employee list
                    $http
                        .delete(
                            "http://localhost:8081/api/v1/employees/" + $scope.deletedEmp.id
                        )
                        .success(function(data) {
                            // refresh the employee list
                            var index = $scope.employees.indexOf($scope.deletedEmp);
                            $scope.employees.splice(index, 1);
                        });
                };
            }
        )

    // employeeController of 'add employee' function
    .controller(
        "employeeController",
        function(
            $scope,
            $routeParams,
            $location,
            employees,
            metawidgetConfig,
            $http
        ) {
            $scope.name = null;
            $scope.email = null;
            $scope.lblMsg = null;

            // Constructor
            switch ($routeParams.add) {
                default: $scope.readOnly = false;
                $scope.current = {};
                $scope.dialogTitle = "Create Employee";
                $scope.current.type = $routeParams.add;
            }

            $scope.metawidgetConfig = metawidgetConfig;

            // CRUD operations
            $scope.crudActions = {
                // When clicking 'save' button
                save: function() {
                    if ($scope.current.jobTitle === undefined) {
                        alert("JobTitle is required");
                        return;
                    }
                    if ($scope.current.firstName === undefined) {
                        alert("Firstname is required");
                        return;
                    }

                    if ($scope.current.surName === undefined) {
                        alert("Surname is required");
                        return;
                    }

                    if ($scope.current.phone === undefined) {
                        alert("Phone is required");
                        return;
                    }

                    if ($scope.current.email === undefined) {
                        alert("Email is required");
                        return;
                    }

                    employees.then(function(result) {
                        var loop, length;

                        if ($scope.current.id === undefined) {
                            // Save new
                            $http
                                .post(
                                    "http://localhost:8081/api/v1/employees",
                                    JSON.stringify($scope.current)
                                )
                                .success(function(data) {
                                    // after saving employee, update the employee list
                                    result.data.push(data);
                                });
                        } else {
                            // Update existing
                            // To be implimented
                        }
                        $location.path("");
                    });
                },
                cancel: function() {
                    $location.path("");
                },
            };
        }
    );
})();