#Automated Testing Framework
#runAllTests.sh
#Lawson, Drayton, Nick

cd $(dirname 0)

#Removes all past instances of results
rm -rf ../testCasesExecutables/*.class
rm -rf ../reports/report.html
rm -rf ../temp/*.txt

#Create table for results

echo "<TABLE BORDER='6'>" >> ../reports/report.html
echo "<TR>" >> ../reports/report.html
echo "</TR>" >> ../reports/report.html
echo "<TR>" >> ../reports/report.html
echo "<TH>Test Case ID</TH>" >> ../reports/report.html
echo "<TH>Requirements</TH>" >> ../reports/report.html
echo "<TH>Component</TH>" >> ../reports/report.html
echo "<TH>Method</TH>" >> ../reports/report.html
echo "<TH>Inputs</TH>" >> ../reports/report.html
echo "<TH>Expected</TH>" >> ../reports/report.html
echo "<TH>Actual</TH>" >> ../reports/report.html
echo "</TR>" >> ../reports/report.html

#Compiles executables
javac ../testCasesExecutables/*
wait

for file in ../testCases/*.txt
do
  i=0;
  fileNoPath=${file##*/}
  fileNoExt=${fileNoPath%.*}

  while read line 
  do
  #ignores lines with # at start
    [[ "${line:0:2}" = // ]] && continue
    arr[$i]="$line"
    echo ${arr[$i]} >> ../temp/"$fileNoExt"report.txt
    i=$((i+1))
  done < $file

  #assign variable names to array value
  declare testid=${arr[0]}
  declare requirement=${arr[1]}
  declare component=${arr[2]}
  declare method=${arr[3]}
  declare inputs=${arr[4]}
  declare expected=${arr[5]}


  if [[ $component == "ContrastChecker" ]]
  then
    cd ../testCasesExecutables
    java ContrastCheckerDriver "$testid" "$requirement" "$component" "$method" "$inputs" "$expected" >> ../temp/"$fileNoExt"report.txt &
  fi
done

wait

for file in ../temp/*
do
echo "<TR ALIGN='CENTER'>" >> ../reports/report.html
  while read line 
  do
  #ignores lines with # at start
    [[ "${line:0:1}" = "/" ]] && continue
    printf "<TD>" >> ../reports/report.html
    arr[$i]="$line"
    echo "${arr[$i]}" >> ../reports/report.html
    echo "</TD>" >> ../reports/report.html
    i=$((i+1))
  done < $file
echo "</TR>" >> ../reports/report.html
done

echo "</TABLE>" >> ../reports/report.html
rm -rf ../testCasesExecutables/*.class
#open only included for testing on mac (redirection(2>&1) to remove cp error)
xdg-open ../reports/report.html 2>&1||open ../reports/report.html 2>&1