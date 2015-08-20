var GoogleMapComposite = React.createClass({

    addMarker : function(latLng, map) {

        var marker = new google.maps.Marker({
            position: latLng,
            map: map,
            title: 'Hello World!'
        });
                
    },  

    componentDidMount :  function() {
       console.debug("composite mounted")
    },

    render: function() {
    
    return  <div>
                <GoogleMap ref="map" lat={this.props.lat} lng={this.props.lng}/>                
/*                <Directions ref="map" lat={this.props.lat} lng={this.props.lng}/>                
*/            </div>
            }
});