pipeline {
agent any
stages
  {
  stage('scan pages')
  {
   steps
    {
    withMaven(maven:'Maven_home')
    {
    bat "mvn sonar:sonar"
    }
	}
  }
 } 
}
