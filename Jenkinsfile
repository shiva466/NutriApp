pipeline {
agent { label 'linux' }
options
{
buildDiscarder(logRotator(numToKeepStr: '5'))
}

stages
  {
  stage('scan pages')
  {
   steps
    {
	withSonarQubeEnv(installationName: 'nutrisonar')
    	{
  		sh './mvnw clean sonar:sonar'
    	}
    }
  }
 } 
}