<!DOCTYPE html>
<html lang="en">


<head>
    <jsp:include page="angular-imports.jsp" />
</head>

<body ng-app="myapp">


<div ng-controller="HelloController" >

    <h2>Hello {{helloTo.title}} !</h2>

</div>


<script>
angular.module("myapp", [])
    .controller("HelloController", function($scope) {
        $scope.helloTo = {};
        $scope.helloTo.title = "World, AngularJS";
    } );
</script>



</body>

</html>  