var GoogleMap = React.createClass({

    componentDidMount :  function() {
        console.debug("Google map component has mounted")
        this.createMap();
        
    },

    createMap : function() {
        var mapOptions = {
                            zoom: 8,
                            center: {lat: -34.397, lng: 150.644}
                        };
        return new google.maps.Map(React.findDOMNode(this.refs.map_canvas), mapOptions);        
    },

    render: function() {
        console.debug("rendering")
            return <div ref="map_canvas">

            </div>
            }
});