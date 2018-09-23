# Team III - Drayton Redick, Nick Foster, Lawson Willard

# Clears the html file to prevent it from repeating itself upon multiple runs.
> myList.html

# Prints the name of the files into the html file.
for d in *; 
	do
	echo "<br>$d" >> myList.html
done

# Allows us to edit the html file.
chmod +x myList.html

# Opens the html file in the browser. 
xdg-open myList.html
