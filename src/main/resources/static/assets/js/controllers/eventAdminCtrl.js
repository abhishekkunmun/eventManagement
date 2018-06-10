eventAdmin.controller('eventAdminCtrl', function($scope, $location, $http, $filter, $localStorage) {


$scope.allEvents=[];

  $scope.fetchAllEvents = function() {
      var res = $http.get("events");
      res.success(function(data) {

        $scope.message = "Success";
        $scope.allEvents = data;
        console.log(data);
        $scope.loading = false;

      });
      res.error(function(data, status, headers, config) {
        $scope.loading = false;
        $scope.message = "Error while fetching events";
      });
    };


$scope.deleteEvent= function(eventId){
  var res = $http.delete("events/"+eventId);
  res.success(function(data) {
    $scope.message = "Success";
    $scope.fetchAllEvents();
  });
  res.error(function(data, status, headers, config) {
    $scope.message = "Error while deleting event";
  });
};

});
