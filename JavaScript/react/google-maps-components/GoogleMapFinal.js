var GoogleMap = React.createClass({

    map : null,

    addMarker : function(map) {
        console.log(map)
        var marker =
            new google.maps.Marker({
                map: map,
                position: new google.maps.LatLng(0,-29)
            });          

            
    },

    placeSearchCallback : function(placeResultArray, placesServiceStatus, placeSearchPagination) {
            this.addMarker(placeResultArray[0])
  },

    componentDidMount :  function() {
        console.log("component has mounted")
        map = new google.maps.Map(React.findDOMNode(this.refs.map_canvas), {
            zoom: 8,
            center: {lat: 51.50417, lng: 0}        });
           

        this.addMarker(map);
    },

    render: function() {
        console.log("rendering")
        return <div ref="map_canvas" className="bigMap">
                    </div>
        
            }
});