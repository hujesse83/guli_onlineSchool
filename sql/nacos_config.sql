-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: nacos_config
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `nacos_config`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `nacos_config` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `nacos_config`;

--
-- Table structure for table `config_info`
--

DROP TABLE IF EXISTS `config_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `c_use` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `effect` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `c_schema` text COLLATE utf8_bin,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info`
--

LOCK TABLES `config_info` WRITE;
/*!40000 ALTER TABLE `config_info` DISABLE KEYS */;
INSERT INTO `config_info` VALUES (8,'service-acl-dev','DEFAULT_GROUP','server.port=9009\nspring.application.name=service-acl\n\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8\n\nmybatis-plus.mapper-locations=classpath:com/atguigu/aclservice/mapper/xml/*.xml\nspring.cloud.nacos.discovery.server-addr=127.0.0.1:8848\n\n','0ea4accc4d868af549a32b66f2745f38','2022-01-25 09:10:23','2022-01-25 09:41:46',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03','','','','properties',''),(13,'service-db.properties','DEFAULT_GROUP','spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver\nspring.datasource.url=jdbc:mysql://localhost:3306/guli?useSSL=false&serverTimezone=GMT%2B8\nspring.datasource.username=root\nspring.datasource.password=root123123','ec00d49e165a4ab10ed99fcab69a1999','2022-01-25 09:34:35','2022-01-25 09:34:35',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(15,'service-redis.properties','DEFAULT_GROUP','spring.redis.host=127.0.0.1\nspring.redis.port=6379\nspring.redis.database= 0\nspring.redis.timeout=1800000\nspring.redis.lettuce.pool.max-active=20\nspring.redis.lettuce.pool.max-wait=-1\nspring.redis.lettuce.pool.max-idle=5\nspring.redis.lettuce.pool.min-idle=0','e3e58e5d49c5fe1fbe742f56fe15f822','2022-01-25 09:35:51','2022-01-25 09:35:51',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(16,'service-cms-dev','DEFAULT_GROUP','server.port=9004\nspring.application.name=service-cms\n\n\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8\n\n\nmybatis-plus.global-config.db-config.logic-delete-field=flag\nmybatis-plus.global-config.db-config.logic-delete-value=1\nmybatis-plus.global-config.db-config.logic-not-delete-value=0\nmybatis-plus.mapper-locations=classpath:com/atguigu/educms/mapper/xml/*.xml','887f686642dda7082d8ee844b159e9ca','2022-01-25 09:40:48','2022-01-25 09:40:48',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(18,'service-msm-dev','DEFAULT_GROUP','server.port=9005\nspring.application.name=service-msm\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8','3202259be0c6ffe1ff495b6d28ee2c4c','2022-01-25 09:45:33','2022-01-25 09:45:33',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(19,'service-order-dev','DEFAULT_GROUP','server.port=9007\nspring.application.name=service-order\n\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8\n\nmybatis-plus.global-config.db-config.logic-delete-field=flag\nmybatis-plus.global-config.db-config.logic-delete-value=1\nmybatis-plus.global-config.db-config.logic-not-delete-value=0\nmybatis-plus.mapper-locations=classpath:com/atguigu/eduorder/mapper/xml/*.xml\n\nspring.cloud.nacos.discovery.server-addr=127.0.0.1:8848\n\nfeign.hystrix.enabled=true\n\nhystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000\n\nwx.open.app_id=wx74862e0dfcf69954\nwx.open.partner=1558950191\nwx.open.partnerkey=T6m9iK73b0kn9g5v426MKfHQH7X8rKwb\nwx.open.notifyurl=http://guli.shop/api/order/weixinPay/weixinNotify','ea97c6c85a28e784302c562f758c7279','2022-01-25 09:47:50','2022-01-25 09:47:50',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(20,'service-oss-dev','DEFAULT_GROUP','server.port=9002\nspring.application.name=service-oss\nspring.profiles.active=dev\nspring.servlet.multipart.max-file-size=50MB\nspring.servlet.multipart.max-request-size=50MB\nspring.cloud.nacos.discovery.server-addr=127.0.0.1:8848\naliyun.oss.file.endPoint=oss-cn-shanghai.aliyuncs.com\naliyun.oss.file.keyId=LTAI5tC97PRptsPVR9c6WcXX\naliyun.oss.file.keySecret=ZbYf3W9NIXsAseSzAjV3ZYAHz8zGY2\naliyun.oss.file.bucketName=guli-edu-9527','c6f40eca341197a1c76675972de283ae','2022-01-25 09:49:52','2022-01-25 09:58:35',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03','','','','properties',''),(22,'service-statistics-dev','DEFAULT_GROUP','server.port=9008\n\nspring.application.name=service-statistics\n\n\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8\n\nmybatis-plus.global-config.db-config.logic-delete-field=flag\nmybatis-plus.global-config.db-config.logic-delete-value=1\nmybatis-plus.global-config.db-config.logic-not-delete-value=0\nmybatis-plus.mapper-locations=classpath:com/atguigu/staservice/mapper/xml/*.xml\n\nspring.cloud.nacos.discovery.server-addr=127.0.0.1:8848\nfeign.hystrix.enabled=true\n\nhystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000','65a709a7100b83d0b7c70bf5237c2cca','2022-01-25 10:00:59','2022-01-25 10:00:59',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(23,'service-ucenter-dev','DEFAULT_GROUP','server.port=8160\nspring.application.name=service-ucenter\n\n\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8\n\n\n\n\nmybatis-plus.global-config.db-config.logic-delete-field=flag\nmybatis-plus.global-config.db-config.logic-delete-value=1\nmybatis-plus.global-config.db-config.logic-not-delete-value=0\nmybatis-plus.mapper-locations=classpath:com/atguigu/educenter/mapper/xml/*.xml\n\nwx.open.app_id=wxed9954c01bb89b47\nwx.open.app_secret=a7482517235173ddb4083788de60b90e\nwx.open.redirect_url=http://localhost:8160/api/ucenter/wx/callback\n\nfeign.hystrix.enabled=true\n\nhystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000','c210869ee700b785aa559639e0376169','2022-01-25 10:03:30','2022-01-25 10:03:30',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(24,'service-vod-dev','DEFAULT_GROUP','server.port=9003\nspring.application.name=service-vod\n\naliyun.vod.file.keyid=LTAI5tC97PRptsPVR9c6WcXX\naliyun.vod.file.keysecret=ZbYf3W9NIXsAseSzAjV3ZYAHz8zGY2\n\nspring.servlet.multipart.max-file-size=1024MB\nspring.servlet.multipart.max-request-size=1024MB\n\nspring.cloud.nacos.discovery.server-addr=127.0.0.1:8848\n\nfeign.hystrix.enabled=true\n\nhystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000','959c3366be733238cfbe6c5c54bc1c25','2022-01-25 10:06:28','2022-01-25 10:06:28',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL),(25,'service-edu-dev','DEFAULT_GROUP','spring.application.name=service-edu\nspring.profiles.active=dev\nspring.datasource.type=com.zaxxer.hikari.HikariDataSource\nspring.datasource.driver-class-name=com.p6spy.engine.spy.P6SpyDriver\nspring.datasource.url=jdbc:p6spy:mysql://localhost:3306/guli?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false\nspring.datasource.username=root\nspring.datasource.password=root123123\nspring.jackson.date-format=yyyy-MM-dd HH:mm:ss\nspring.jackson.time-zone=GMT+8\nspring.cloud.nacos.discovery.server-addr=127.0.0.1:8848\nspring.redis.host=127.0.0.1\nspring.redis.port=6379\nspring.redis.database=0\nspring.redis.lettuce.pool.max-active=28\nspring.redis.lettuce.pool.max-wait=-1\nspring.redis.lettuce.pool.max-idle=5\nspring.redis.lettuce.pool.min-idle=0\nmybatis-plus.global-config.db-config.logic-delete-field=flag\nmybatis-plus.global-config.db-config.logic-delete-value=1\nmybatis-plus.global-config.db-config.logic-not-delete-value=0\nmybatis-plus.mapper-locations=classpath:com/atguigu/eduservice/mapper/xml/*.xml\nhikari.connection-test-query=SELECT 1\nhikari.connection-timeout=60000\nhikari.idle-timeout=500000\nhikari.max-lifetime=540000\nhikari.maximum-pool-size=12\nhikari.minimum-idle=10\nhikari.pool-name=GuliHikariPool\nserver.port=9001\nfeign.hystrix.enabled=true\n','5677e4f405f13a4baccef341d1eb0557','2022-01-25 10:13:32','2022-01-25 10:13:32',NULL,'0:0:0:0:0:0:0:1','','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03',NULL,NULL,NULL,'properties',NULL);
/*!40000 ALTER TABLE `config_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_aggr`
--

DROP TABLE IF EXISTS `config_info_aggr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_aggr` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='增加租户字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_aggr`
--

LOCK TABLES `config_info_aggr` WRITE;
/*!40000 ALTER TABLE `config_info_aggr` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_aggr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_beta`
--

DROP TABLE IF EXISTS `config_info_beta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_beta` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_beta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_beta`
--

LOCK TABLES `config_info_beta` WRITE;
/*!40000 ALTER TABLE `config_info_beta` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_beta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_tag`
--

DROP TABLE IF EXISTS `config_info_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_tag';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_tag`
--

LOCK TABLES `config_info_tag` WRITE;
/*!40000 ALTER TABLE `config_info_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_tags_relation`
--

DROP TABLE IF EXISTS `config_tags_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_tags_relation` (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_tag_relation';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_tags_relation`
--

LOCK TABLES `config_tags_relation` WRITE;
/*!40000 ALTER TABLE `config_tags_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_tags_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_capacity`
--

DROP TABLE IF EXISTS `group_capacity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='集群、各Group容量信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_capacity`
--

LOCK TABLES `group_capacity` WRITE;
/*!40000 ALTER TABLE `group_capacity` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_capacity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `his_config_info`
--

DROP TABLE IF EXISTS `his_config_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `his_config_info` (
  `id` bigint unsigned NOT NULL,
  `nid` bigint unsigned NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text COLLATE utf8_bin,
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `op_type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多租户改造';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `his_config_info`
--

LOCK TABLES `his_config_info` WRITE;
/*!40000 ALTER TABLE `his_config_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `his_config_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `role` varchar(50) NOT NULL,
  `resource` varchar(255) NOT NULL,
  `action` varchar(8) NOT NULL,
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('nacos','ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_capacity`
--

DROP TABLE IF EXISTS `tenant_capacity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租户容量信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_capacity`
--

LOCK TABLES `tenant_capacity` WRITE;
/*!40000 ALTER TABLE `tenant_capacity` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_capacity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_info`
--

DROP TABLE IF EXISTS `tenant_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='tenant_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_info`
--

LOCK TABLES `tenant_info` WRITE;
/*!40000 ALTER TABLE `tenant_info` DISABLE KEYS */;
INSERT INTO `tenant_info` VALUES (1,'1','1242b4e2-70e1-4fdb-8df2-d9f05ff86b03','dev','development environment','nacos',1643101760898,1643101760898),(2,'1','dcefddf4-6022-4815-8a08-7ab82bc91e92','prod','product environment','nacos',1643101784439,1643101784439),(3,'1','6c43206b-698e-4652-a15d-a0e991537df9','qa','quality environment','nacos',1643101806434,1643101806434);
/*!40000 ALTER TABLE `tenant_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('nacos','$2a$10$qrwWnIwSsWY/Tp3UyD7AO.au0Y/scWJpYO7ozR2UpzMG2tCmNRq3O',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-13 13:18:18
