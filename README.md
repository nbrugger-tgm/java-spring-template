# java-spring-template
A template to create high quality Spring APIS

## Features:
- [ ] Advanced gradle build
- [ ] Ready to go Docker build
- [ ] Open Api Specification (aka OAS/Swagger) tooling
    - [ ] Generate specfile from code
    - [ ] Verfiy PRs
    - [ ] Autogenerate clients on change
    - [ ] Autogenerate beautiful HTML documentation
- [ ] Clean gradle multimodule structure
- [ ] CI/CD Github action workflow(s) for:
    - [ ] Building
    - [ ] Quality checks with SonarCloud (optional)
    - [ ] Codecoverage check with JaCoCo
    - [ ] Codecoverage upload to codeclimate (optional)
    - [ ] Codecoverage upload to codacy (optional)
    - [ ] Deployment (only with docker)
    - [ ] Upload to docker repo (optional)
- [ ] (automatic) Semantic versioning by using [`conventional commits`](https://www.conventionalcommits.org/en/v1.0.0/)
- [ ] `Readme.md`template ([here](readme-template.md)) that contains a few badges and a quite ok layout 


## Benefits 
Using theese checks and options will ensure that your API uses clean code, is well structured and up to the standards of modern software development.

Also the amount of manual work is very limited as mostly everything is automated with gradle or github.<br/>**You write the code, commit, fix style issues and you are done!**

## Setup
- [ ] Create a sonar cloud account OR a codacy account (for sonarcloud you can also host it yourself)
- [ ] Add the `SONAR_TOKEN` secreet as described in the sonar cloud guide
- [ ] Configure to your needs using `config.gradle`
- [ ] Be proud of your good code quality and add [hundreds of badged](https://shields.io/) from sonarcloud that proove your testcoverage
