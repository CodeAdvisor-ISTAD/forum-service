package com.example.forumcodeadvisors.init;

import com.example.forumcodeadvisors.domain.ForumTag;
import com.example.forumcodeadvisors.feature.tag.repository.ForumTagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class tags {

    private final ForumTagRepository forumTagRepository;

    @PostConstruct
    public void init() {
        if (forumTagRepository.count() == 0) {
            ForumTag java = new ForumTag();
            java.setName("java");

            ForumTag spring = new ForumTag();
            spring.setName("spring-boot");

            ForumTag kotlin = new ForumTag();
            kotlin.setName("kotlin");

            ForumTag go = new ForumTag();
            go.setName("golang");

            ForumTag python = new ForumTag();
            python.setName("python");

            ForumTag javascript = new ForumTag();
            javascript.setName("javascript");

            ForumTag typescript = new ForumTag();
            typescript.setName("typescript");

            ForumTag html = new ForumTag();
            html.setName("html");

            ForumTag css = new ForumTag();
            css.setName("css");

            ForumTag bootstrap = new ForumTag();
            bootstrap.setName("bootstrap");

            ForumTag tailwind = new ForumTag();
            tailwind.setName("tailwind");

            ForumTag sql = new ForumTag();
            sql.setName("sql");

            ForumTag postgresql = new ForumTag();
            postgresql.setName("postgresql");

            ForumTag mysql = new ForumTag();
            mysql.setName("mysql");

            ForumTag mongodb = new ForumTag();
            mongodb.setName("mongodb");

            ForumTag redis = new ForumTag();
            redis.setName("redis");

            ForumTag elasticsearch = new ForumTag();
            elasticsearch.setName("elasticsearch");

            ForumTag kafka = new ForumTag();
            kafka.setName("kafka");

            ForumTag docker = new ForumTag();
            docker.setName("docker");

            ForumTag kubernetes = new ForumTag();
            kubernetes.setName("kubernetes");

            ForumTag jenkins = new ForumTag();
            jenkins.setName("jenkins");

            ForumTag aws = new ForumTag();
            aws.setName("aws");

            ForumTag azure = new ForumTag();
            azure.setName("azure");

            ForumTag gcp = new ForumTag();
            gcp.setName("gcp");

            ForumTag ciCd = new ForumTag();
            ciCd.setName("ci-cd");

            ForumTag git = new ForumTag();
            git.setName("git");

            ForumTag github = new ForumTag();
            github.setName("github");

            ForumTag gitlab = new ForumTag();
            gitlab.setName("gitlab");

            ForumTag bitbucket = new ForumTag();
            bitbucket.setName("bitbucket");

            ForumTag devops = new ForumTag();
            devops.setName("devops");

            ForumTag restApi = new ForumTag();
            restApi.setName("rest-api");

            ForumTag graphql = new ForumTag();
            graphql.setName("graphql");

            ForumTag microservices = new ForumTag();
            microservices.setName("microservices");

            ForumTag hibernate = new ForumTag();
            hibernate.setName("hibernate");

            ForumTag jpa = new ForumTag();
            jpa.setName("jpa");

            ForumTag springSecurity = new ForumTag();
            springSecurity.setName("spring-security");

            ForumTag jwt = new ForumTag();
            jwt.setName("jwt");

            ForumTag oauth2 = new ForumTag();
            oauth2.setName("oauth2");

            ForumTag unitTesting = new ForumTag();
            unitTesting.setName("unit-testing");

            ForumTag integrationTesting = new ForumTag();
            integrationTesting.setName("integration-testing");

            ForumTag jest = new ForumTag();
            jest.setName("jest");

            ForumTag mocha = new ForumTag();
            mocha.setName("mocha");

            ForumTag cypress = new ForumTag();
            cypress.setName("cypress");

            ForumTag selenium = new ForumTag();
            selenium.setName("selenium");

            ForumTag flutter = new ForumTag();
            flutter.setName("flutter");

            ForumTag dart = new ForumTag();
            dart.setName("dart");

            ForumTag rust = new ForumTag();
            rust.setName("rust");

            ForumTag scala = new ForumTag();
            scala.setName("scala");

            ForumTag c = new ForumTag();
            c.setName("c");

            ForumTag cpp = new ForumTag();
            cpp.setName("c++");

            ForumTag ruby = new ForumTag();
            ruby.setName("ruby");

            ForumTag php = new ForumTag();
            php.setName("php");

            ForumTag rubyOnRails = new ForumTag();
            rubyOnRails.setName("ruby-on-rails");

            ForumTag aspNet = new ForumTag();
            aspNet.setName("asp.net");

            ForumTag django = new ForumTag();
            django.setName("django");

            ForumTag flask = new ForumTag();
            flask.setName("flask");

            ForumTag fastApi = new ForumTag();
            fastApi.setName("fastapi");

            ForumTag machineLearning = new ForumTag();
            machineLearning.setName("machine-learning");

            ForumTag artificialIntelligence = new ForumTag();
            artificialIntelligence.setName("artificial-intelligence");

            ForumTag dataScience = new ForumTag();
            dataScience.setName("data-science");

            ForumTag pandas = new ForumTag();
            pandas.setName("pandas");

            ForumTag numpy = new ForumTag();
            numpy.setName("numpy");

            ForumTag scikitLearn = new ForumTag();
            scikitLearn.setName("scikit-learn");

            ForumTag tensorflow = new ForumTag();
            tensorflow.setName("tensorflow");

            ForumTag pytorch = new ForumTag();
            pytorch.setName("pytorch");

            ForumTag spark = new ForumTag();
            spark.setName("apache-spark");

            ForumTag hadoop = new ForumTag();
            hadoop.setName("hadoop");

            ForumTag bigData = new ForumTag();
            bigData.setName("big-data");

            ForumTag cassandra = new ForumTag();
            cassandra.setName("cassandra");

            ForumTag couchbase = new ForumTag();
            couchbase.setName("couchbase");

            ForumTag graphQLApi = new ForumTag();
            graphQLApi.setName("graphql-api");

            ForumTag expressJs = new ForumTag();
            expressJs.setName("expressjs");

            ForumTag nestJs = new ForumTag();
            nestJs.setName("nestjs");

            ForumTag sequelize = new ForumTag();
            sequelize.setName("sequelize");

            ForumTag prisma = new ForumTag();
            prisma.setName("prisma");

            ForumTag webpack = new ForumTag();
            webpack.setName("webpack");

            ForumTag rollup = new ForumTag();
            rollup.setName("rollup");

            ForumTag vite = new ForumTag();
            vite.setName("vite");

            ForumTag babel = new ForumTag();
            babel.setName("babel");

            ForumTag eslint = new ForumTag();
            eslint.setName("eslint");

            ForumTag prettier = new ForumTag();
            prettier.setName("prettier");

            ForumTag tailwindUi = new ForumTag();
            tailwindUi.setName("tailwind-ui");

            ForumTag materialUi = new ForumTag();
            materialUi.setName("material-ui");

            ForumTag antDesign = new ForumTag();
            antDesign.setName("ant-design");

            ForumTag chakraUi = new ForumTag();
            chakraUi.setName("chakra-ui");

            ForumTag vuetify = new ForumTag();
            vuetify.setName("vuetify");

            ForumTag svelte = new ForumTag();
            svelte.setName("svelte");

            ForumTag d3js = new ForumTag();
            d3js.setName("d3.js");

            ForumTag chartJs = new ForumTag();
            chartJs.setName("chart.js");

            ForumTag threeJs = new ForumTag();
            threeJs.setName("three.js");

            ForumTag nextAuth = new ForumTag();
            nextAuth.setName("next-auth");

            ForumTag firebase = new ForumTag();
            firebase.setName("firebase");

            ForumTag supabase = new ForumTag();
            supabase.setName("supabase");

            ForumTag sanity = new ForumTag();
            sanity.setName("sanity");

            ForumTag strapi = new ForumTag();
            strapi.setName("strapi");

            ForumTag swagger = new ForumTag();
            swagger.setName("swagger");

            ForumTag openApi = new ForumTag();
            openApi.setName("openapi");

            ForumTag jsonWebToken = new ForumTag();
            jsonWebToken.setName("json-web-token");

            ForumTag keycloak = new ForumTag();
            keycloak.setName("keycloak");

            ForumTag sonarQube = new ForumTag();
            sonarQube.setName("sonarqube");

            ForumTag logstash = new ForumTag();
            logstash.setName("logstash");

            ForumTag prometheus = new ForumTag();
            prometheus.setName("prometheus");

            ForumTag grafana = new ForumTag();
            grafana.setName("grafana");

            ForumTag newRelic = new ForumTag();
            newRelic.setName("new-relic");

            ForumTag datadog = new ForumTag();
            datadog.setName("datadog");

            // Save all ForumTag
            forumTagRepository.saveAll(List.of(
                    java, spring, kotlin, go, python, javascript, typescript, html, css, bootstrap,
                    tailwind, sql, postgresql, mysql, mongodb, redis, elasticsearch, kafka, docker,
                    kubernetes, jenkins, aws, azure, gcp, ciCd, git, github, gitlab, bitbucket,
                    devops, restApi, graphql, microservices, hibernate, jpa, springSecurity, jwt,
                    oauth2, unitTesting, integrationTesting, jest, mocha, cypress, selenium,
                    flutter, dart, rust, scala, c, cpp, ruby, php, rubyOnRails, aspNet, django, flask, fastApi, machineLearning, artificialIntelligence,
                    dataScience, pandas, numpy, scikitLearn, tensorflow, pytorch, spark, hadoop, bigData,
                    cassandra, couchbase, graphQLApi, expressJs, nestJs, sequelize, prisma, webpack, rollup,
                    vite, babel, eslint, prettier, tailwindUi, materialUi, antDesign, chakraUi, vuetify,
                    svelte, d3js, chartJs, threeJs, nextAuth, firebase, supabase, sanity, strapi, swagger,
                    openApi, jsonWebToken, keycloak, sonarQube, logstash, prometheus, grafana, newRelic, datadog
            ));
        }
    }
}
