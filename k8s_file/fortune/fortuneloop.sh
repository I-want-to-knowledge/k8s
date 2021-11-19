#!/bin/bash
trap "exit" SIGINT
v=$1
[ ! "$v" ] && v=20
echo $v seconds!!!
mkdir -p /var/htdocs

while :
do
	# shellcheck disable=SC2046
	echo $(date) Writing fortune to /var/htdocs/index.html
	/usr/games/fortune > /var/htdocs/index.html
	sleep $v
done