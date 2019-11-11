package main

import (
    "os"
	"fmt"
	"net/http"
)

func main() {

	name := "default"
	if value, ok := os.LookupEnv("NAME"); ok {
		name = value
	}
	
	response := fmt.Sprintln("Response from server:", name)

	http.HandleFunc("/", func (w http.ResponseWriter, req *http.Request) {
		fmt.Printf("Request: %+v\n", req)
		fmt.Fprintf(w, response)
	})

	fmt.Println("Starting server:", name)

	http.ListenAndServe(":8080", nil)
}