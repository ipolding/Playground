// tutorial4.js
var TextEntry = React.createClass({
  render: function() {
    return (
      <div className="comment">
        <input defaultValue={this.props.artist}></input>          
          {this.props.children}
      </div>
    );
  }
});

var TextEntryForm = React.createClass({
  handleSubmit: function(e) {
    e.preventDefault();
    var artist = this.refs.artist.value.trim();
    if (!artist) {
      return;
    }
    this.props.onTextEntrySubmit({artist: artist});
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

// tutorial10.js
var TextList = React.createClass({
  render: function() {
    var commentNodes = this.props.data.map(function (comment) {
      return (
        <TextEntry artist={comment.artist}>
          {comment.text}
        </TextEntry>
      );
    });
    return (
      <div className="textlist">
        {commentNodes}
      </div>
    );
  }
});

var TextEntryBox = React.createClass({
  handleTextEntrySubmit: function(comment) {
    var comments = this.state.data;
    var newTextEntrys = comments.concat([comment]);
    this.setState({data: newTextEntrys});
  },
  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
   console.log("TextEntryBox did mount")
  },
  render: function() {
    return (
      <div className="commentBox">
        <h1>Artists</h1>
        <TextList data={this.state.data} />
        <TextEntryForm onTextEntrySubmit={this.handleTextEntrySubmit} />
      </div>
    );
  }
});

ReactDOM.render(
  <TextEntryBox />,
  document.getElementById('artistList')
);

//https://facebook.github.io/react/docs/tutorial.html
//We can optimistically add this comment to the list to make the app feel faster.