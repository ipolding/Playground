// tutorial10.js
var TextList = React.createClass({
  render: function() {
    var commentNodes = this.props.data.map(function (comment) {
      return (
        <Comment artist={comment.artist}>
          {comment.text}
        </Comment>
      );
    });
    return (
      <div className="textlisT">
        {commentNodes}
      </div>
    );
  }
});