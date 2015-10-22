/*
* Use '/' for *nix. Use whatever your root directory is on Windows.
* Must be run as admin or root dir and file will not be created.
*/
.shell mkdir "docs";
.shell mkdir "/docs";
.output output.txt
.output /output.txt
