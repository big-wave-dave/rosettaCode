#!/usr/bin/perl
use strict;
use warnings;
use 5.020;
#This script is dependent upon the Net::FTP cpan module
use Net::FTP;

#Put the name of the FTP server here
my $host = "kernel.org";
#Credentials go here
my $user = "anonymous";
my $password = "";

#Attempt to connect to the server using the credentials provided.
my $f = Net::FTP->new($host) or die("Something went wrong. Can't open $host\n");
$f->login($user, $password) or die("Something went wrong. Can't log $user in.\n");

#Set to passive mode
$f->passive();

#Change to whatever directory you want. If no args are passed to cwd(), it sets it to the root directory 
$f->cwd("pub/linux/kernel");
#Print the current dir
my @dir = $f->ls();
foreach my $element (@dir)
{
    say("$element");
}

#Download the file and store locally. get() returns the local filename
my $local = $f->get("README");
say("Your file was stored as $local in the current directory! ");
