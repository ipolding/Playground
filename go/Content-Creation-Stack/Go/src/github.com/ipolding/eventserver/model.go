package eventserver

type Event struct {
    Title string `json:"title"`
    Location string `json:"location"`
    Description string `json:"description"`
}