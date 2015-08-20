var GoogleMap = React.createClass({

    getInitialState : function() {
        return {
            markers: []
            } 
    },

    addMarker : function(latLng, map) {

        var marker = new google.maps.Marker({
            position: latLng,
            map: map,
            title: 'Hello World!'
        });
                
        this.setState({markers: [marker]})
    },  

    componentDidMount :  function() {
        var markerPosition = {lat: this.props.lat, lng: this.props.lng}
        console.log("component has mounted")
        var map = new google.maps.Map(React.findDOMNode(this.refs.map_canvas), 
                            {
                             minZoom: 3,
                             zoom: 13,
                             center: markerPosition
                            });

                            console.debug("props="+this.props)
                            console.debug("state="+this.state)

                

                this.addMarker(markerPosition, map)
    },

    render: function() {
    
    return <div ref="map_canvas" className="bigMap"></div>
            }
});