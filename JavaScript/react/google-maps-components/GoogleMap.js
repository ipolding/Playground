var GoogleMap = React.createClass({

    componentDidMount :  function() {
        console.log("component has mounted")
        new google.maps.Map(document.getElementById('map-canvas'), {
            zoom: 8,
            center: {lat: -34.397, lng: 150.644}
        });
    },

    render: function() {
        console.log("rendering")
            return <div ref="map-canvas">

            </div>
            }
});