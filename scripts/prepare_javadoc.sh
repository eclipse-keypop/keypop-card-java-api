#!/bin/sh

echo "Compute the current API version..."

repository_name=$1
version=$2
is_snapshot=$3

if [ "$is_snapshot" = true ]
then
  version="$version-SNAPSHOT"
fi

echo "Computed current API version: $version"

echo "Clone $repository_name..."
git clone https://github.com/eclipse-keypop/$repository_name.git

cd $repository_name

echo "Checkout gh-pages branch..."
git checkout -f gh-pages

echo "Delete existing SNAPSHOT directory..."
rm -rf *-SNAPSHOT

echo "Delete existing RC directories in case of final release..."
rm -rf $version-rc*

echo "Create target directory $version..."
mkdir $version

echo "Copy javadoc files..."
cp -rf ../build/docs/javadoc/* $version/

echo "Update versions list..."
echo "| Version | Documents |" > list_versions.md
echo "|:---:|---|" >> list_versions.md
for directory in `ls -rd [0-9]*/ | cut -f1 -d'/'`
do
  echo "| $directory | [API documentation]($directory) |" >> list_versions.md
done

echo "Computed all versions:"
cat list_versions.md

cd ..

echo "Local docs update finished."



