// tutorial4.js
var Comment = React.createClass({
  render: function() {
    return (
      <div className="comment">
        <input value={this.props.artist}></input>          
          {this.props.children}
      </div>
    );
  }
});

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

var CommentForm = React.createClass({
  handleSubmit: function(e) {
    e.preventDefault();
    var artist = this.refs.artist.value.trim();
    if (!artist) {
      return;
    }
    this.props.onCommentSubmit({artist: artist});
    this.refs.artist.value = '';    
    return;
  },
  render: function() {
    return (
      <form className="commentForm" onSubmit={this.handleSubmit}>
        <input type="text" placeholder="Artist" ref="artist" />        
      </form>
    );
  }
});

var CommentBox = React.createClass({
  handleCommentSubmit: function(comment) {
    var comments = this.state.data;
    var newComments = comments.concat([comment]);
    this.setState({data: newComments});
  },
  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
   console.log("CommentBox did mount")
  },
  render: function() {
    return (
      <div className="commentBox">
        <h1>Artists</h1>
        <TextList data={this.state.data} />
        <CommentForm onCommentSubmit={this.handleCommentSubmit} />
      </div>
    );
  }
});

ReactDOM.render(
  <CommentBox />,
  document.getElementById('artistList')
);

//https://facebook.github.io/react/docs/tutorial.html
//We can optimistically add this comment to the list to make the app feel faster.