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
  		sh './mvnw clean sonar:sonar'
    	}
	}
  }
 } 
}
