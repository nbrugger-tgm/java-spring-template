# java-spring-template

A template to create high quality Spring APIS.

This template is not meant to be a quick-and-dirty start, but rather an easy automation setup. While
most things are preconfigured you still have to do one or two things by yourself.

The focus of this repo is automating literally everything thats possible. When you use this repo you
as a developer just need to develop. No deployment affort, no version managent worries. No need to
manage reviews, automatic code maintance.

## Features:

- [x] Advanced gradle build
- [x] Preconfigured IntelliJ project
- [ ] Ready to go Docker build
- [ ] Open Api Specification (aka OAS/Swagger) tooling
    - [x] Generate specfile from code
    - [ ] Verfiy PRs
    - [x] Autogenerate clients on change
    - [x] Autogenerate beautiful HTML documentation
- [x] Clean gradle multimodule structure
- [ ] CI/CD Github action workflow(s) for:
    - [ ] Building
    - [ ] Quality checks with SonarCloud (optional)
    - [ ] Codecoverage check with JaCoCo
    - [ ] Codecoverage upload to codeclimate (optional)
    - [ ] Codecoverage upload to codacy (optional)
    - [ ] Deployment (only with docker)
    - [ ] Upload to docker repo (optional)
- [ ] (automatic) Semantic versioning by
  using [`conventional commits`](https://www.conventionalcommits.org/en/v1.0.0/)
- [ ] `Readme.md`template ([here](readme-template.md)) that contains a few badges and a quite ok
  layout

## Benefits

Using theese checks and options will ensure that your API uses clean code, is well structured and up
to the standards of modern software development.

Also the amount of manual work is very limited as mostly everything is automated with gradle or
github.<br/>**You write the code, commit, fix style issues and you are done!**

## Setup

- [ ] Create a sonar cloud account OR a codacy account (for sonarcloud you can also host it
  yourself)
- [ ] Add the `SONAR_TOKEN` secreet as described in the sonar cloud guide
- [ ] Configure to your needs using `config.gradle`
- [ ] Be proud of your good code quality and add [hundreds of badged](https://shields.io/) (for
  example from sonarcloud) that proove your testcoverage
