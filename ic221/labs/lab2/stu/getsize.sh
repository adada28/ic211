#!/bin/bash
  
if [ -e $1 ];
then 
  cat $1 | wc -c 
else
  echo "File doesn't exist"

fi
