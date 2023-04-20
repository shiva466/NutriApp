pipeline
{
agent any
	environment
	{
		DOCKERHUB_CREDENTIALS = credentials('dockerhub')
	}
	tools {
		maven "maven"
		dockerTool "docker"
	       }
	stages
	{
		stage('maven install and test')
		{
			steps
			{
				withMaven(maven:'maven')
				{
					bat "mvn clean install"
				}
			}
			post
			{
				success
				{
					junit 'target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar'
				}
			}
		}
		stage('Sonar scan')
		{
			steps
			{
				 withSonarQubeEnv('nutrisonar')
				{
				withMaven(maven:'maven')
				{
					bat "mvn sonar:sonar"
				}
				}
			}
		}
		stage('docker build')
		{
			steps
			{
				bat 'docker build -t nutritionapp:latest .'
			}
		}
		stage('docker image tag')
		{
			steps
			{
				bat 'docker tag nutritionapp:latest saishiva466/nutritionapp:latest'
			}
		}
		stage('docker login')
		{
			steps
			{
				bat 'echo | set /p ="***" | docker login --username saishiva466 --password Choco@2014'
			}
		}
		stage('docker push')
		{
			steps
			{
				bat 'docker push saishiva466/nutritionapp:latest'
			}
		}
		
	}
}
post {
  success {
    emailext body: 'The pipeline job has completed successfully', subject: 'Pipeline job successful notification', to: 'shiva.ayyala@gmail.com'
  }
}
