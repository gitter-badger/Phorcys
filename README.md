# Phorcys: a browser-based graphics server
Phorcys (pronounced /ˈfɔːrsᵻs/, "forceus"), a god of the hidden changes of the deep.

Originally forked from [display](https://github.com/szym/display) which was forked from [gfx.js](https://github.com/clementfarabet/gfx.js/).

The ultimate goal of this project is to provide a simple visualisation package for python based projects.

Why port from Lua?
Most linux machines come with python.


Install for Python (`numpy` required) via:

    python setup.py install [--user]

See `example.py` for sample usage.

from PyDisplay import *
image(image_data, title='My Image')
plot(data, labels=[ 'position', 'a', 'b' ], title='My Plot')

### Supported commands

Common parameters:
  - `win`: identifier of the window to be reused (pick a random one if you want a new window)
  - `title`: title for the window title bar

`image` creates a zoomable `<img>` element
  - `src`: URL for the `<img>` element
  - `width`: initial width in pixels
  - `labels`: array of 3-element arrays `[ x, y, text ]`, where `x`, `y` are the coordinates
    `(0, 0)` is top-left, `(1, 1)` is bottom-right; `text` is the label content

`plot` creates a Dygraph, all [Dygraph options](http://dygraphs.com/options.html) are supported
  - `file`: see [Dygraph data formats](http://dygraphs.com/data.html) for supported formats
  - `labels`: list of strings, first element is the X label

`text` sends raw HTML

`audio` creates an audio pane

`mesh` given a set of 3D vertices and faces, will create a Three.Js rendering

`isosurface` given a 3D volume, will render the isosurface using Three.Js and the marching cubes algorithm

`graph3d` creates a 3D graph of multiple types, using vis.js

## Technical overview

The server is a trivial message forwarder:

    POST /events -> EventSource('/events')

The Lua client sends JSON commands directly to the server. The browser script
interprets these commands, e.g.

    { command: 'image', src: 'data:image/png;base64,....', title: 'lena' }

## TODO

Replace Dygraph with Visjs

Commands:
`audio` - port from [display](https://github.com/szym/display) - Mostly completed
`WebGL` - possibly use Vispy or raw Three.js - On its way
`video` - could possibly just use raw video html tags

Higher Level functions:
   - Display Fully Connected Layer weights
   - Display Convolution Layer weights
   - API's for interacting with other packages e.g. Keras, Lasagne
