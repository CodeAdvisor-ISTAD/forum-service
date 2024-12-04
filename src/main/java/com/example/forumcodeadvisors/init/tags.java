package com.example.forumcodeadvisors.init;

import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.tag.repository.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class tags {

    private final TagRepository forumTagRepository;

    private Tag createTag(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        tag.setSlug(name.toLowerCase().replace(" ", "-"));
        tag.setUuid(UUID.randomUUID().toString());
        return tag;
    }

    @PostConstruct
    public void init() {
        if (forumTagRepository.count() == 0) {
            Tag java = createTag("java");
            Tag spring = createTag("spring-boot");
            Tag kotlin = createTag("kotlin");
            Tag go = createTag("golang");
            Tag python = createTag("python");
            Tag javascript = createTag("javascript");
            Tag typescript = createTag("typescript");
            Tag html = createTag("html");
            Tag css = createTag("css");
            Tag bootstrap = createTag("bootstrap");
            Tag tailwind = createTag("tailwind");
            Tag sql = createTag("sql");
            Tag postgresql = createTag("postgresql");
            Tag mysql = createTag("mysql");
            Tag mongodb = createTag("mongodb");
            Tag redis = createTag("redis");
            Tag elasticsearch = createTag("elasticsearch");
            Tag kafka = createTag("kafka");
            Tag docker = createTag("docker");
            Tag kubernetes = createTag("kubernetes");
            Tag jenkins = createTag("jenkins");
            Tag aws = createTag("aws");
            Tag azure = createTag("azure");
            Tag gcp = createTag("gcp");
            Tag ciCd = createTag("ci-cd");
            Tag git = createTag("git");
            Tag github = createTag("github");
            Tag gitlab = createTag("gitlab");
            Tag bitbucket = createTag("bitbucket");
            Tag devops = createTag("devops");
            Tag restApi = createTag("rest-api");
            Tag graphql = createTag("graphql");
            Tag microservices = createTag("microservices");
            Tag hibernate = createTag("hibernate");
            Tag jpa = createTag("jpa");
            Tag springSecurity = createTag("spring-security");
            Tag jwt = createTag("jwt");
            Tag oauth2 = createTag("oauth2");
            Tag unitTesting = createTag("unit-testing");
            Tag integrationTesting = createTag("integration-testing");
            Tag jest = createTag("jest");
            Tag mocha = createTag("mocha");
            Tag cypress = createTag("cypress");
            Tag selenium = createTag("selenium");
            Tag flutter = createTag("flutter");
            Tag dart = createTag("dart");
            Tag rust = createTag("rust");
            Tag scala = createTag("scala");
            Tag c = createTag("c");
            Tag cpp = createTag("c++");
            Tag ruby = createTag("ruby");
            Tag php = createTag("php");
            Tag rubyOnRails = createTag("ruby-on-rails");
            Tag aspNet = createTag("asp.net");
            Tag django = createTag("django");
            Tag flask = createTag("flask");
            Tag fastApi = createTag("fastapi");
            Tag machineLearning = createTag("machine-learning");
            Tag artificialIntelligence = createTag("artificial-intelligence");
            Tag dataScience = createTag("data-science");
            Tag pandas = createTag("pandas");
            Tag numpy = createTag("numpy");
            Tag scikitLearn = createTag("scikit-learn");
            Tag tensorflow = createTag("tensorflow");
            Tag pytorch = createTag("pytorch");
            Tag spark = createTag("apache-spark");
            Tag hadoop = createTag("hadoop");
            Tag bigData = createTag("big-data");
            Tag cassandra = createTag("cassandra");
            Tag couchbase = createTag("couchbase");
            Tag graphQLApi = createTag("graphql-api");
            Tag expressJs = createTag("expressjs");
            Tag nestJs = createTag("nestjs");
            Tag sequelize = createTag("sequelize");
            Tag prisma = createTag("prisma");
            Tag webpack = createTag("webpack");
            Tag rollup = createTag("rollup");
            Tag vite = createTag("vite");
            Tag babel = createTag("babel");
            Tag eslint = createTag("eslint");
            Tag prettier = createTag("prettier");
            Tag tailwindUi = createTag("tailwind-ui");
            Tag materialUi = createTag("material-ui");
            Tag antDesign = createTag("ant-design");
            Tag chakraUi = createTag("chakra-ui");
            Tag vuetify = createTag("vuetify");
            Tag svelte = createTag("svelte");
            Tag d3js = createTag("d3.js");
            Tag chartJs = createTag("chart.js");
            Tag threeJs = createTag("three.js");
            Tag nextAuth = createTag("next-auth");
            Tag firebase = createTag("firebase");
            Tag supabase = createTag("supabase");
            Tag sanity = createTag("sanity");
            Tag strapi = createTag("strapi");
            Tag swagger = createTag("swagger");
            Tag openApi = createTag("openapi");
            Tag jsonWebToken = createTag("json-web-token");
            Tag keycloak = createTag("keycloak");
            Tag sonarQube = createTag("sonarqube");
            Tag logstash = createTag("logstash");
            Tag prometheus = createTag("prometheus");
            Tag grafana = createTag("grafana");
            Tag newRelic = createTag("new-relic");
            Tag datadog = createTag("datadog");

            // Save all tags
            forumTagRepository.saveAll(List.of(
                    java, spring, kotlin, go, python, javascript, typescript, html, css, bootstrap,
                    tailwind, sql, postgresql, mysql, mongodb, redis, elasticsearch, kafka, docker,
                    kubernetes, jenkins, aws, azure, gcp, ciCd, git, github, gitlab, bitbucket,
                    devops, restApi, graphql, microservices, hibernate, jpa, springSecurity, jwt,
                    oauth2, unitTesting, integrationTesting, jest, mocha, cypress, selenium,
                    flutter, dart, rust, scala, c, cpp, ruby, php, rubyOnRails, aspNet, django,
                    flask, fastApi, machineLearning, artificialIntelligence, dataScience, pandas,
                    numpy, scikitLearn, tensorflow, pytorch, spark, hadoop, bigData, cassandra,
                    couchbase, graphQLApi, expressJs, nestJs, sequelize, prisma, webpack, rollup,
                    vite, babel, eslint, prettier, tailwindUi, materialUi, antDesign, chakraUi,
                    vuetify, svelte, d3js, chartJs, threeJs, nextAuth, firebase, supabase, sanity,
                    strapi, swagger, openApi, jsonWebToken, keycloak, sonarQube, logstash,
                    prometheus, grafana, newRelic, datadog
            ));
        }
    }
}
