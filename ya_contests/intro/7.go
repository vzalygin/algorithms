package intro

import (
	"fmt"
	"strconv"
	"time"
)

func main() {
	var inp string
	layout := "15:04:05"
	fmt.Scan(&inp)
	a, _ := time.Parse(layout, inp)
	fmt.Scan(&inp)
	b, _ := time.Parse(layout, inp)
	fmt.Scan(&inp)
	c, _ := time.Parse(layout, inp)

	d := ((24*time.Hour + c.Sub(a)) % (24 * time.Hour)) / 2
	if d.Milliseconds()%1000 >= 500 {
		d += 10e8 - (d % 10e8)
	} else {
		d -= d % 10e8
	}
	b = b.Add(d)

	fmt.Print(
		strconv.Itoa(100 + b.Hour())[1:], ":",
		strconv.Itoa(100 + b.Minute())[1:], ":",
		strconv.Itoa(100 + b.Second())[1:],
	)
}
