if [[ $# -eq 0 ]] ; then
    echo "No args were supplied. Please try again. For example: './init-win.sh my-service'"
	exit 1
fi

# First arg is our service name
SERVICE_NAME=${1,,}
# Remove hypens from the service name to get our service name for java packages and folders
SERVICE_NAME_NO_HYPHENS=${SERVICE_NAME//-}

echo Initializing microservice... $SERVICE_NAME

# Delete .git folder so we have to re-init git
rm -rf ./.git

# Replace template text in yaml and settings files
sed -i -e 's/mckesson-service-template/'$SERVICE_NAME'/g' ./manifest.yml
sed -i -e 's/mckesson-service-template/'$SERVICE_NAME'/g' ./manifest-qa.yml
sed -i -e 's/mckesson-service-template/'$SERVICE_NAME'/g' ./settings.gradle
sed -i -e 's/mckesson-service-template/'$SERVICE_NAME'/g' ./src/main/resources/bootstrap.yaml

# Replace template text in main/java packages
sed -i -e 's/template/'$SERVICE_NAME_NO_HYPHENS'/g' ./src/main/java/com/mckesson/ms/template/Application.java
sed -i -e 's/template/'$SERVICE_NAME_NO_HYPHENS'/g' ./src/main/java/com/mckesson/ms/template/v1/dto/SampleObject.java
sed -i -e 's/template/'$SERVICE_NAME_NO_HYPHENS'/g' ./src/main/java/com/mckesson/ms/template/v1/endpoint/AbstractEndpoint.java
sed -i -e 's/template/'$SERVICE_NAME_NO_HYPHENS'/g' ./src/main/java/com/mckesson/ms/template/v1/endpoint/SampleEndpoint.java

# Replace template text in test/java packages
sed -i -e 's/template/'$SERVICE_NAME_NO_HYPHENS'/g' ./src/test/java/com/mckesson/ms/template/AbstractEndpointTest.java
sed -i -e 's/template/'$SERVICE_NAME_NO_HYPHENS'/g' ./src/test/java/com/mckesson/ms/template/v1/endpoint/SampleEndpointTest.java

# Rename package folders
mv ./src/main/java/com/mckesson/ms/template ./src/main/java/com/mckesson/ms/$SERVICE_NAME_NO_HYPHENS
mv ./src/test/java/com/mckesson/ms/template ./src/test/java/com/mckesson/ms/$SERVICE_NAME_NO_HYPHENS

# Replace template text for swagger
sed -i -e 's/McKesson Boot Template/'$SERVICE_NAME'/g' ./src/main/resources/application.yml
sed -i -e 's/Sample project to get started/A microservice for '$SERVICE_NAME'/g' ./src/main/resources/application.yml

# Initialize a new Git repo
git init

echo 'Add your ASCII Art to ./src/main/resources/banner.txt'

echo 'Finished!'

rm -f ./init-mac.sh
rm -f ./init-win.sh