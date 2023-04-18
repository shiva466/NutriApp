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
		sh 'pwd'
		sh 'ls'
  		sh 'mvn clean sonar:sonar'
    	}
	}
  }
 } 
}
