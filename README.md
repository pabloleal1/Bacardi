# aws-appium-cucumber-example

For generate ZIP file for AWS Device Farm :

*mvn clean package*

For execute:

*mvn clean test -Ddevice=${udid} -DappiumON=${S/N}*

If you execute this project using AWS Device Farm, you must indicate -DappiumON parameter as "S" value because AWS has an Appium instance running before you run the test, otherwise indicate "N".

Instructor: Matthew Kim

APK file from : https://code.tutsplus.com/tutorials/an-introduction-to-appium--cms-23861
