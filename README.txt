notes:

need to manually install a couple jars:
    1. amazonaws android
        download link: http://d3rhhoifpheis6.cloudfront.net/latest/aws-android-sdk.zip
            -unzip, grab jar: aws-android-sdk-1.0.4-debug.jar
            -install to local repository with:
                mvn install:install-file -DgroupId=com.amazonaws  -DartifactId=aws-android-sdk  -Dversion=1.0.4  -Dfile=<path-to-file>/aws-android-sdk-1.0.4-debug.jar  -Dpackaging=jar -DgeneratePom=true
                
    *2. trimmed-down zeitdata-core
          -navigate to core project, and run:
                mvn clean  package -Dmaven.test.skip -Pandroid-library -Dandroid
          
          -now, install the resulting       
                mvn install:install-file -Dfile=./target/zeitdata-core-1.0-SNAPSHOT-android-library.jar -DgroupId=zeitdata -DartifactId=zeitdata-core-android -Dversion=1.0-SNAPSHOT -Dpackaging=jar
                

* alternatively, you can use the build.sh script included in the base android directory that will do this automatically


Misc notes on how to test (from the command line)
1. Create an AVD (emulator), and make sure its version is >=8
   $ android avd

2. Deploy android app to emular, once emulator is running: 
   $ adb install ..../target/android.-...sdk

3. View logs for the device
   $ adb logcat

4. Inject new location coordinates into the device
   $ telnet localhost 5554
   .. should connect and give you an OK prompt
   geo fix -23.7 52.3


07/16/2012 addition:

download achartengine from http://code.google.com/p/achartengine/downloads/list.  Take 1.0.0

mvn install:install-file -Dfile=./achartengine-1.0.0.jar -DgroupId=org.achartengine -DartifactId=achartengine -Dversion=1.0 -Dpackaging=jar
