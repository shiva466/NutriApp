pipeline {
agent any
stages
  {
  stage('scan pages')
  {
   steps
    {
   withSonarQubeEnv(installationName: 'nutrisonar')
    	{
  		sh 'mvn clean sonar:sonar'
    	}
	}
  }
 } 
}
