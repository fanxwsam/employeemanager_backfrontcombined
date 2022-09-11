(function() {
    "use strict";

    /* App Module */
    angular
        .module("employeeManager", [
            "ngRoute",
            "controllers",
            "services",
            "metawidget",
        ])

    .config([
        "$routeProvider",
        function($routeProvider) {
            $routeProvider

                .when("/employee/:add", {
                    templateUrl: "partials/employee-add.html",
                    controller: "employeeController",
                })
                .when("", {
                    templateUrl: "partials/employee-none.html",
                })
                .otherwise({
                    redirectTo: "",
                });
        },
    ]);
})();