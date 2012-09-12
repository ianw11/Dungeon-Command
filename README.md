Dungeon-Command
===============

At some point, download baseboards from google code.  Good stuff there.

Skiller for potential multiplayer.
Parse for Android.
http://gitref.org/
http://learn.github.com/p/intro.html
http://rogerdudler.github.com/git-guide/




http://code.google.com/p/baseboards/
Grid<Object> holds the 'pieces' ( = new OriginRangeGrid<Object>(1,1) //assuming 1x1 grid
The Grid is like a 2 dimensional array.

then pieces.put(new Creature(), Space.get(0,0)); Space might have some power over this Grid and handles filling

GridPane is what displays the Grid that was created, as GridPane extends(?) JComponent
GridPane grid = new GridPane(pieces);
add(grid);
pack();



https://developers.google.com/java-dev-tools/download-wbpro

http://roseindia.net/java/example/java/swing/chess-application-swing.shtml