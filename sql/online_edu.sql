-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: guli
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
-- Current Database: `guli`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `guli` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `guli`;

--
-- Table structure for table `acl_permission`
--

DROP TABLE IF EXISTS `acl_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acl_permission` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '编号',
  `pid` char(19) NOT NULL DEFAULT '' COMMENT '所属上级',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型(1:菜单,2:按钮)',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限值',
  `path` varchar(100) DEFAULT NULL COMMENT '访问路径',
  `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` tinyint DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_permission`
--

LOCK TABLES `acl_permission` WRITE;
/*!40000 ALTER TABLE `acl_permission` DISABLE KEYS */;
INSERT INTO `acl_permission` VALUES ('1','0','全部数据',0,NULL,NULL,NULL,NULL,NULL,0,'2019-11-15 17:13:06','2019-11-15 17:13:06'),('1195268474480156673','1','权限管理',1,NULL,'/acl','Layout',NULL,NULL,0,'2019-11-15 17:13:06','2019-11-18 13:54:25'),('1195268616021139457','1195268474480156673','用户管理',1,NULL,'user/list','/acl/user/list',NULL,NULL,0,'2019-11-15 17:13:40','2019-11-18 13:53:12'),('1195268788138598401','1195268474480156673','角色管理',1,NULL,'role/list','/acl/role/list',NULL,NULL,0,'2019-11-15 17:14:21','2019-11-15 17:14:21'),('1195268893830864898','1195268474480156673','菜单管理',1,NULL,'menu/list','/acl/menu/list',NULL,NULL,0,'2019-11-15 17:14:46','2019-11-15 17:14:46'),('1195269143060602882','1195268616021139457','查看',2,'user.list','','',NULL,NULL,0,'2019-11-15 17:15:45','2019-11-17 21:57:16'),('1195269295926206466','1195268616021139457','添加',2,'user.add','user/add','/acl/user/form',NULL,NULL,0,'2019-11-15 17:16:22','2019-11-15 17:16:22'),('1195269473479483394','1195268616021139457','修改',2,'user.update','user/update/:id','/acl/user/form',NULL,NULL,0,'2019-11-15 17:17:04','2019-11-15 17:17:04'),('1195269547269873666','1195268616021139457','删除',2,'user.remove','','',NULL,NULL,0,'2019-11-15 17:17:22','2019-11-15 17:17:22'),('1195269821262782465','1195268788138598401','修改',2,'role.update','role/update/:id','/acl/role/form',NULL,NULL,0,'2019-11-15 17:18:27','2019-11-15 17:19:53'),('1195269903542444034','1195268788138598401','查看',2,'role.list','','',NULL,NULL,0,'2019-11-15 17:18:47','2019-11-15 17:18:47'),('1195270037005197313','1195268788138598401','添加',2,'role.add','role/add','/acl/role/form',NULL,NULL,0,'2019-11-15 17:19:19','2019-11-18 11:05:42'),('1195270442602782721','1195268788138598401','删除',2,'role.remove','','',NULL,NULL,0,'2019-11-15 17:20:55','2019-11-15 17:20:55'),('1195270621548568578','1195268788138598401','角色权限',2,'role.acl','role/distribution/:id','/acl/role/roleForm',NULL,NULL,0,'2019-11-15 17:21:38','2019-11-15 17:21:38'),('1195270744097742849','1195268893830864898','查看',2,'permission.list','','',NULL,NULL,0,'2019-11-15 17:22:07','2019-11-15 17:22:07'),('1195270810560684034','1195268893830864898','添加',2,'permission.add','','',NULL,NULL,0,'2019-11-15 17:22:23','2019-11-15 17:22:23'),('1195270862100291586','1195268893830864898','修改',2,'permission.update','','',NULL,NULL,0,'2019-11-15 17:22:35','2019-11-15 17:22:35'),('1195270887933009922','1195268893830864898','删除',2,'permission.remove','','',NULL,NULL,0,'2019-11-15 17:22:41','2019-11-15 17:22:41'),('1195349439240048642','1','讲师管理',1,NULL,'/edu/teacher','Layout',NULL,NULL,0,'2019-11-15 22:34:49','2019-11-15 22:34:49'),('1195349699995734017','1195349439240048642','讲师列表',1,NULL,'list','/edu/teacher/list',NULL,NULL,0,'2019-11-15 22:35:52','2019-11-15 22:35:52'),('1195349810561781761','1195349439240048642','添加讲师',1,NULL,'save','/edu/teacher/save',NULL,NULL,0,'2019-11-15 22:36:18','2022-01-25 12:18:06'),('1195349876252971010','1195349810561781761','添加',2,'teacher.add','','',NULL,NULL,0,'2019-11-15 22:36:34','2019-11-15 22:36:34'),('1195349979797753857','1195349699995734017','查看',2,'teacher.list','','',NULL,NULL,0,'2019-11-15 22:36:58','2019-11-15 22:36:58'),('1195350117270261762','1195349699995734017','修改',2,'teacher.update','edit/:id','/edu/teacher/save',NULL,NULL,0,'2019-11-15 22:37:31','2022-01-25 12:07:18'),('1195350188359520258','1195349699995734017','删除',2,'teacher.remove','','',NULL,NULL,0,'2019-11-15 22:37:48','2019-11-15 22:37:48'),('1195350299365969922','1','课程分类',1,NULL,'/edu/subject','Layout',NULL,NULL,0,'2019-11-15 22:38:15','2019-11-15 22:38:15'),('1195350397751758850','1195350299365969922','课程分类列表',1,NULL,'list','/edu/subject/list',NULL,NULL,0,'2019-11-15 22:38:38','2019-11-15 22:38:38'),('1195350500512206850','1195350299365969922','导入课程分类',1,NULL,'save','/edu/subject/save',NULL,NULL,0,'2019-11-15 22:39:03','2022-01-25 12:25:46'),('1195350612172967938','1195350397751758850','查看',2,'subject.list','','',NULL,NULL,0,'2019-11-15 22:39:29','2019-11-15 22:39:29'),('1195350687590748161','1195350500512206850','导入',2,'subject.import','','',NULL,NULL,0,'2019-11-15 22:39:47','2019-11-15 22:39:47'),('1195350831744782337','1','课程管理',1,NULL,'/edu/course','Layout',NULL,NULL,0,'2019-11-15 22:40:21','2019-11-15 22:40:21'),('1195350919074385921','1195350831744782337','课程列表',1,NULL,'list','/edu/course/list',NULL,NULL,0,'2019-11-15 22:40:42','2019-11-15 22:40:42'),('1195351020463296513','1195350831744782337','发布课程',1,NULL,'info','/edu/course/info',NULL,NULL,0,'2019-11-15 22:41:06','2019-11-15 22:41:06'),('1195351159672246274','1195350919074385921','完成发布',2,'course.publish','publish/:id','/edu/course/publish',NULL,NULL,0,'2019-11-15 22:41:40','2019-11-15 22:44:01'),('1195351326706208770','1195350919074385921','编辑课程',2,'course.update','info/:id','/edu/course/info',NULL,NULL,0,'2019-11-15 22:42:19','2019-11-15 22:42:19'),('1195351566221938690','1195350919074385921','编辑课程大纲',2,'chapter.update','chapter/:id','/edu/course/chapter',NULL,NULL,0,'2019-11-15 22:43:17','2019-11-15 22:43:17'),('1195351862889254913','1','统计分析',1,NULL,'/sta','Layout',NULL,NULL,0,'2019-11-15 22:44:27','2022-01-25 12:27:28'),('1195351968841568257','1195351862889254913','生成统计',1,NULL,'create','/sta/create',NULL,NULL,0,'2019-11-15 22:44:53','2022-01-25 12:27:52'),('1195352054917074946','1195351862889254913','统计图表',1,NULL,'show','/sta/show',NULL,NULL,0,'2019-11-15 22:45:13','2022-01-25 12:38:25'),('1195352127734386690','1195352054917074946','查看',2,'daily.list','','',NULL,NULL,0,'2019-11-15 22:45:30','2019-11-15 22:45:30'),('1195352215768633346','1195351968841568257','生成',2,'daily.add','','',NULL,NULL,0,'2019-11-15 22:45:51','2019-11-15 22:45:51'),('1195352547621965825','1','CMS管理',1,NULL,'/cms','Layout',NULL,NULL,0,'2019-11-15 22:47:11','2019-11-18 10:51:46'),('1195352856645701633','1195353513549205505','查看',2,'banner.list','',NULL,NULL,NULL,0,'2019-11-15 22:48:24','2019-11-15 22:48:24'),('1195352909401657346','1195353513549205505','添加',2,'banner.add','banner/add','/cms/banner/form',NULL,NULL,0,'2019-11-15 22:48:37','2019-11-18 10:52:10'),('1195353051395624961','1195353513549205505','修改',2,'banner.update','banner/update/:id','/cms/banner/form',NULL,NULL,0,'2019-11-15 22:49:11','2019-11-18 10:52:05'),('1195353513549205505','1195352547621965825','Bander列表',1,NULL,'banner/list','/cms/banner/list',NULL,NULL,0,'2019-11-15 22:51:01','2019-11-18 10:51:29'),('1195353672110673921','1195353513549205505','删除',2,'banner.remove','','',NULL,NULL,0,'2019-11-15 22:51:39','2019-11-15 22:51:39'),('1195354076890370050','1','订单管理',1,NULL,'/order','Layout',NULL,NULL,0,'2019-11-15 22:53:15','2019-11-15 22:53:15'),('1195354153482555393','1195354076890370050','订单列表',1,NULL,'list','/order/list',NULL,NULL,0,'2019-11-15 22:53:33','2019-11-15 22:53:58'),('1195354315093282817','1195354153482555393','查看',2,'order.list','','',NULL,NULL,0,'2019-11-15 22:54:12','2019-11-15 22:54:12'),('1196301740985311234','1195268616021139457','分配角色',2,'user.assgin','user/role/:id','/acl/user/roleForm',NULL,NULL,0,'2019-11-18 13:38:56','2019-11-18 13:38:56');
/*!40000 ALTER TABLE `acl_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_role`
--

DROP TABLE IF EXISTS `acl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acl_role` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '角色id',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_role`
--

LOCK TABLES `acl_role` WRITE;
/*!40000 ALTER TABLE `acl_role` DISABLE KEYS */;
INSERT INTO `acl_role` VALUES ('1','普通管理员',NULL,NULL,0,'2019-11-11 13:09:32','2019-11-18 10:27:18'),('1193757683205607426','课程管理员',NULL,NULL,0,'2019-11-11 13:09:45','2019-11-18 10:25:44'),('1485630879195328514','L admin hah',NULL,NULL,0,'2022-01-24 23:09:38','2022-01-25 11:31:48');
/*!40000 ALTER TABLE `acl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_role_permission`
--

DROP TABLE IF EXISTS `acl_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acl_role_permission` (
  `id` char(19) NOT NULL DEFAULT '',
  `role_id` char(19) NOT NULL DEFAULT '',
  `permission_id` char(19) NOT NULL DEFAULT '',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_role_permission`
--

LOCK TABLES `acl_role_permission` WRITE;
/*!40000 ALTER TABLE `acl_role_permission` DISABLE KEYS */;
INSERT INTO `acl_role_permission` VALUES ('1484778850176495618','1196300996034977794','1195268788138598401',0,'2022-01-22 14:43:58','2022-01-22 14:43:58'),('1485817619440779266','1485630879195328514','1195269547269873666',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485817619449167874','1485630879195328514','1195268788138598401',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485817619453362177','1485630879195328514','1195269821262782465',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485817619457556481','1485630879195328514','1195269903542444034',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485817619465945090','1485630879195328514','1195270037005197313',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485817619474333698','1485630879195328514','1195270442602782721',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485817619482722305','1485630879195328514','1195270621548568578',0,'2022-01-25 11:31:40','2022-01-25 11:31:40'),('1485842617803071489','1193757683205607426','1',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617811460097','1193757683205607426','1195268474480156673',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617815654401','1193757683205607426','1195268616021139457',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617819848705','1193757683205607426','1195269143060602882',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617824043010','1193757683205607426','1195269295926206466',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617828237313','1193757683205607426','1195269473479483394',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617832431618','1193757683205607426','1195269547269873666',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617840820225','1193757683205607426','1196301740985311234',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617845014530','1193757683205607426','1195268788138598401',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617853403137','1193757683205607426','1195269821262782465',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617857597442','1193757683205607426','1195269903542444034',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617861791745','1193757683205607426','1195270037005197313',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617865986049','1193757683205607426','1195270442602782721',0,'2022-01-25 13:11:00','2022-01-25 13:11:00'),('1485842617870180354','1193757683205607426','1195270621548568578',0,'2022-01-25 13:11:00','2022-01-25 13:11:00');
/*!40000 ALTER TABLE `acl_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_user`
--

DROP TABLE IF EXISTS `acl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acl_user` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '微信openid',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `salt` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `token` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_user`
--

LOCK TABLES `acl_user` WRITE;
/*!40000 ALTER TABLE `acl_user` DISABLE KEYS */;
INSERT INTO `acl_user` VALUES ('1','admin','96e79218965eb72c92a549dd5a330112','admin','',NULL,0,'2019-11-01 10:39:47','2019-11-01 10:39:47'),('1485841859586154498','testRole','96e79218965eb72c92a549dd5a330112','testRole',NULL,NULL,0,'2022-01-25 13:08:00','2022-01-25 13:08:00');
/*!40000 ALTER TABLE `acl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_user_role`
--

DROP TABLE IF EXISTS `acl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acl_user_role` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '主键id',
  `role_id` char(19) NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` char(19) NOT NULL DEFAULT '0' COMMENT '用户id',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_user_role`
--

LOCK TABLES `acl_user_role` WRITE;
/*!40000 ALTER TABLE `acl_user_role` DISABLE KEYS */;
INSERT INTO `acl_user_role` VALUES ('1485645955881066497','1','1',0,'2022-01-25 00:09:33','2022-01-25 00:09:33'),('1485816682991108097','1','2',0,'2022-01-25 11:27:57','2022-01-25 11:27:57'),('1485816683012079617','1193757683205607426','2',0,'2022-01-25 11:27:57','2022-01-25 11:27:57'),('1485817551002320897','1193757683205607426','1485817344801947649',0,'2022-01-25 11:31:24','2022-01-25 11:31:24'),('1485817551006515202','1','1485817344801947649',0,'2022-01-25 11:31:24','2022-01-25 11:31:24'),('1485842656667492353','1193757683205607426','1485841859586154498',0,'2022-01-25 13:11:10','2022-01-25 13:11:10');
/*!40000 ALTER TABLE `acl_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_banner`
--

DROP TABLE IF EXISTS `crm_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crm_banner` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20) DEFAULT '' COMMENT '标题',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片地址',
  `link_url` varchar(500) DEFAULT '' COMMENT '链接地址',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首页banner表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_banner`
--

LOCK TABLES `crm_banner` WRITE;
/*!40000 ALTER TABLE `crm_banner` DISABLE KEYS */;
INSERT INTO `crm_banner` VALUES ('1194556896025845762','test1','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cms/2019/11/14/297acd3b-b592-4cfb-a446-a28310369675.jpg','/course',1,1,'2019-11-13 18:05:32','2019-11-18 10:28:22'),('1194607458461216769','test2','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cms/2019/11/13/8f80790d-d736-4842-a6a4-4dcb0d684d4e.jpg','/teacher',2,0,'2019-11-13 21:26:27','2019-11-14 09:12:15'),('1481521870410461185','1','11','1',10,10,'2022-01-13 15:01:54','2022-01-13 15:01:54'),('1481522095942381569','11','2','1',110,1,'2022-01-13 15:02:48','2022-01-13 15:02:48'),('1481522134332846081','3','3','1',3,1,'2022-01-13 15:02:57','2022-01-13 15:02:57');
/*!40000 ALTER TABLE `crm_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_chapter`
--

DROP TABLE IF EXISTS `edu_chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_chapter`
--

LOCK TABLES `edu_chapter` WRITE;
/*!40000 ALTER TABLE `edu_chapter` DISABLE KEYS */;
INSERT INTO `edu_chapter` VALUES ('1','14','第一章：HTML',0,'2019-01-01 12:27:40','2019-01-01 12:55:30',0),('1181729226915577857','18','第七章：I/O流哦',70,'2019-10-09 08:32:58','2022-01-06 02:28:38',0),('1192252428399751169','1192252213659774977','第一章节',0,'2019-11-07 09:28:25','2019-11-07 09:28:25',0),('1480437725168959489','1480437708827951105','123123',0,'2022-01-10 01:13:54','2022-01-10 01:13:54',1),('1480437741744848898','1480437708827951105','555',0,'2022-01-10 01:13:57','2022-01-10 01:13:57',1),('1480438533407137793','1480438507754774529','1零零落落',0,'2022-01-10 01:17:06','2022-01-10 01:17:06',1),('1480438570874855426','1480438507754774529','不知道啊',0,'2022-01-10 01:17:15','2022-01-10 01:17:15',1),('1481158482379489281','1481158461152116738','11',0,'2022-01-12 00:57:55','2022-01-12 00:57:55',1),('1481158494563942402','1481158461152116738','12',0,'2022-01-12 00:57:58','2022-01-12 00:57:58',1),('1481161494858678274','1481161462789029890','hahahJaJa',10,'2022-01-12 01:09:54','2022-01-12 01:09:54',1),('1483269995420504066','1483269974700642306','111',10,'2022-01-17 20:48:19','2022-01-17 20:48:19',1),('1484365655787962369','1484365637194612737','qw',10,'2022-01-20 21:22:05','2022-01-20 21:22:05',0),('15','18','第一章：Java入门',0,'2019-01-01 12:27:40','2019-10-09 09:13:19',0),('3','14','第二章：CSS',0,'2019-01-01 12:55:35','2019-01-01 12:27:40',0),('32','18','第二章：控制台输入和输出',0,'2019-01-01 12:27:40','2019-01-01 12:27:40',0),('44','18','第三章：控制流',0,'2019-01-01 12:27:40','2019-01-01 12:27:40',0),('48','18','第四章：类的定义',0,'2019-01-01 12:27:40','2019-01-01 12:27:40',0),('63','18','第五章：数组',0,'2019-01-01 12:27:40','2019-01-01 12:27:40',0),('64','18','第六章：继承',61,'2019-01-01 12:27:40','2019-10-09 08:32:47',0);
/*!40000 ALTER TABLE `edu_chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_comment`
--

DROP TABLE IF EXISTS `edu_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_comment` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `parent_id` varchar(19) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_comment`
--

LOCK TABLES `edu_comment` WRITE;
/*!40000 ALTER TABLE `edu_comment` DISABLE KEYS */;
INSERT INTO `edu_comment` VALUES ('1194499162790211585','1192252213659774977','1189389726308478977','1','小三123','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','课程很好',0,'2019-11-13 14:16:08','2019-11-13 14:16:08','1'),('1194898406466420738','1192252213659774977','1189389726308478977','1','小三123','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','11',0,'2019-11-14 16:42:35','2019-11-14 16:42:35','1'),('1194898484388200450','1192252213659774977','1189389726308478977','1','小三123','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','111',0,'2019-11-14 16:42:53','2019-11-14 16:42:53','1'),('1195251020861317122','1192252213659774977','1189389726308478977','1',NULL,NULL,'2233',0,'2019-11-15 16:03:45','2019-11-15 16:03:45','1'),('1195251382720700418','1192252213659774977','1189389726308478977','1',NULL,NULL,'4455',0,'2019-11-15 16:05:11','2019-11-15 16:05:11','1'),('1195252819177570306','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','55',0,'2019-11-15 16:10:53','2019-11-15 16:10:53','1'),('1195252899448160258','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','55',0,'2019-11-15 16:11:13','2019-11-15 16:11:13','1'),('1195252920587452417','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','223344',0,'2019-11-15 16:11:18','2019-11-15 16:11:18','1'),('1195262128095559681','14','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','11',0,'2019-11-15 16:47:53','2019-11-15 16:47:53','0'),('1196264505170767874','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','666666',0,'2019-11-18 11:10:58','2019-11-18 11:10:58','1'),('1486327943323566082','18','','1483341562783477761','haha','','haha',0,'2022-01-26 07:19:31','2022-01-26 07:19:31','0'),('1486334664867692546','14','','','','','hello, world',0,'2022-01-26 07:46:14','2022-01-26 07:46:14','0'),('1486334753199734785','14','','','','','[微笑][挤眼]',0,'2022-01-26 07:46:35','2022-01-26 07:46:35','0'),('1486335434035937281','14','','','','','hello',0,'2022-01-26 07:49:17','2022-01-26 07:49:17','0'),('1486338194533892097','14','','','','','评论终于好了!!',0,'2022-01-26 08:00:15','2022-01-26 08:00:15','1'),('1486338344933244929','14','','','','','测试多级评论',0,'2022-01-26 08:00:51','2022-01-26 08:00:51','1195262128095559681'),('1486340325609320449','14','','','','','za[睡][睡]',0,'2022-01-26 08:08:43','2022-01-26 08:08:43','1486335434035937281'),('1486340378210086913','14','','','','','[心]111',0,'2022-01-26 08:08:56','2022-01-26 08:08:56','1486338344933244929'),('1486343081808146434','14','','','','','test',0,'2022-01-26 08:19:40','2022-01-26 08:19:40','0'),('1486343784295346178','14','','','','','test',0,'2022-01-26 08:22:28','2022-01-26 08:22:28','1195262128095559681'),('1486344045839560705','14','','','','','多级评论失效',0,'2022-01-26 08:23:30','2022-01-26 08:23:30','0'),('1486346306892378114','14','','','','','disqus评论也挺酷,',0,'2022-01-26 08:32:29','2022-01-26 08:32:29','0');
/*!40000 ALTER TABLE `edu_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_course`
--

DROP TABLE IF EXISTS `edu_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_course`
--

LOCK TABLES `edu_course` WRITE;
/*!40000 ALTER TABLE `edu_course` DISABLE KEYS */;
INSERT INTO `edu_course` VALUES ('1192252213659774977','1189389726308478977','1178214681139539969','1178214681118568449','java基础课程：test',0.01,2,'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/cover/default.gif',4,387,1,'Normal',0,'2019-11-07 09:27:33','2019-11-18 13:35:03'),('14','1189389726308478977','1101348944971091969','1101348944920760321','XHTML CSS2 JS整站制作教程课程学习',0.00,3,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/143e4bbb01f4478bb16a247458fa48adfavImg4.jpeg',3,44,16,'Normal',0,'2018-04-02 18:33:34','2022-01-19 00:37:49'),('1477931089024000002','33','44','1','lol lol lol lol lol lol lol',99.90,9,'332',0,0,1,'Draft',0,'2022-01-03 03:13:25','2022-01-03 03:13:25'),('1477931726746951682','33','44','1','ellyelly',99.90,9,'332',0,0,1,'Draft',0,'2022-01-03 03:15:57','2022-01-03 03:15:57'),('1477949419604721666','1189389726308478977','1178214681584136193','1','我喜欢送心意',1.00,1,'/static/01.jpg',0,0,1,'Draft',0,'2022-01-03 04:26:15','2022-01-03 04:26:15'),('1478301522126716929','1','1178214681139539969','1','hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh',10.00,10,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/bb63c20290774e2aa31dfa858f378709Screen Shot 2021-11-08 at 17.33.53.png',0,0,1,'Draft',0,'2022-01-04 03:45:23','2022-01-04 03:45:23'),('1478303183733907457','1189390295668469762','1178585108454121473','1','看看坎坎坷坷坎坎坷坷',10.00,1,'/static/dataType.png',0,0,1,'Draft',0,'2022-01-04 03:51:59','2022-01-04 03:51:59'),('1478303897164046338','1','1178214681139539969','1','2132423',20.00,20,'/static/dataType.png',0,0,1,'Draft',0,'2022-01-04 03:54:49','2022-01-04 03:54:49'),('1478304136742690818','1189390295668469762','1178214681139539969','1','123',10.00,10,'/static/dataType.png',0,0,1,'Draft',0,'2022-01-04 03:55:46','2022-01-04 03:55:46'),('1478306286323372033','1','1178214681139539969','1178214681118568449','额外人玩儿玩儿',120.00,11,'/static/dataType.png',0,0,1,'Draft',0,'2022-01-04 04:04:19','2022-01-04 04:04:19'),('1478538592380260353','','','','',0.00,0,'/static/dataType.png',0,0,1,'Draft',0,'2022-01-04 19:27:25','2022-01-04 19:27:25'),('1478621378877325314','','','','',0.00,0,'/static/dataType.png',0,0,1,'Draft',1,'2022-01-05 00:56:23','2022-01-05 00:56:23'),('1478621972736245762','1','1178214681139539969','1178214681118568449','k;sda',0.00,10,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/c2a8d3dd392847eaab3cc7e58fbff1ccjo.png',0,0,2,'Normal',0,'2022-01-05 00:58:44','2022-01-19 00:37:03'),('1478643685737889794','1','1178214681139539969','1178214681118568449','wwwwwwwwwwwwwwww',10.00,11,'/static/dataType.png',0,0,1,'Draft',1,'2022-01-05 02:25:01','2022-01-05 02:39:01'),('1480438507754774529','1189390295668469762','1178214681139539969','1178214681118568449','DDDDDDDDDDDDD',10.00,10,'/static/dataType.png',0,0,2,'Normal',1,'2022-01-10 01:17:00','2022-01-10 01:17:19'),('1481158461152116738','1189390295668469762','1178585108454121473','1178214681181483010','testBatchDelete',10.00,10,'/static/dataType.png',0,0,2,'Normal',1,'2022-01-12 00:57:50','2022-01-12 01:00:44'),('1481161462789029890','1','1178214681139539969','1178214681118568449','我爱大乱的',10.00,10,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/b21e5c5099db48b5a80fdaaa9986d1f2Screen Shot 2021-11-08 at 17.03.05.png',0,0,2,'Normal',1,'2022-01-12 01:09:46','2022-01-12 01:10:41'),('1483269974700642306','1','1178214681139539969','1178214681118568449','播放视频',0.00,10,'/static/dataType.png',0,0,3,'Normal',1,'2022-01-17 20:48:14','2022-01-17 20:50:32'),('1484365637194612737','1','1178214681139539969','1178214681118568449','asd',0.00,10,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/20d6051deafc40f0a9a856a7987ef1b7Screen Shot 2021-12-26 at 10.40.02.png',0,0,2,'Normal',0,'2022-01-20 21:22:01','2022-01-20 21:22:39'),('1485917481989591041','1189389726308478977','1178214681139539969','1178214681118568449','1',0.00,0,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/fe10c412a1054385a79d4cd0ee58fa5cfile.png',0,0,1,'Draft',0,'2022-01-25 04:08:29','2022-01-25 04:08:29'),('15','1189389726308478977','1101348944971091969','1101348944920760321','HTML5入门课程学习',0.00,23,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/1198047da27d45959c1c32123bbe429bfavImg3.jpeg',0,51,18,'Normal',0,'2018-04-02 18:34:32','2022-01-19 00:37:23'),('18','1189389726308478977','1178214681139539969','1178214681118568449','Java精品课程',0.01,20,'\nhttps://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/12409440fa24444287090202783ecbc7JavaAnnotations.jpeg',151,737,8,'Normal',0,'2018-04-02 21:28:46','2022-01-07 03:45:05');
/*!40000 ALTER TABLE `edu_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_course_collect`
--

DROP TABLE IF EXISTS `edu_course_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_course_collect` (
  `id` char(19) NOT NULL COMMENT '收藏ID',
  `course_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_course_collect`
--

LOCK TABLES `edu_course_collect` WRITE;
/*!40000 ALTER TABLE `edu_course_collect` DISABLE KEYS */;
INSERT INTO `edu_course_collect` VALUES ('1196269345666019330','1192252213659774977','1',1,'2019-11-18 11:30:12','2019-11-18 11:30:12');
/*!40000 ALTER TABLE `edu_course_collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_course_description`
--

DROP TABLE IF EXISTS `edu_course_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `description` text COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程简介';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_course_description`
--

LOCK TABLES `edu_course_description` WRITE;
/*!40000 ALTER TABLE `edu_course_description` DISABLE KEYS */;
INSERT INTO `edu_course_description` VALUES ('1104870479077879809','<p>11</p>','2019-03-11 06:23:44','2019-03-11 06:23:44',0),('1192252213659774977','<p>测试</p>','2019-11-07 09:27:33','2019-11-13 16:21:28',0),('14','','2019-03-13 06:04:43','2022-01-19 00:37:47',0),('1477931089024000002',NULL,'2022-01-03 03:13:25','2022-01-03 03:13:25',0),('1477931726746951682',NULL,'2022-01-03 03:15:57','2022-01-03 03:15:57',0),('1477949419604721666',NULL,'2022-01-03 04:26:15','2022-01-03 04:26:15',0),('1478301522126716929','<p>hahh</p>','2022-01-04 03:45:23','2022-01-04 03:45:23',0),('1478303183733907457','<p>阿斯顿</p>','2022-01-04 03:51:59','2022-01-04 03:51:59',0),('1478303897164046338','<p>234</p>','2022-01-04 03:54:49','2022-01-04 03:54:49',0),('1478304136742690818','<p>1</p>','2022-01-04 03:55:46','2022-01-04 03:55:46',0),('1478306286323372033','<p>123</p>','2022-01-04 04:04:19','2022-01-04 04:04:19',0),('1478538592380260353','','2022-01-04 19:27:25','2022-01-04 19:27:25',0),('1478538856747241473','','2022-01-04 19:28:28','2022-01-04 19:28:28',0),('1478621378877325314','','2022-01-05 00:56:23','2022-01-05 00:56:23',1),('1478621972736245762','','2022-01-05 00:58:44','2022-01-19 00:37:00',0),('1478643685737889794','<p>12343</p>','2022-01-05 02:25:01','2022-01-05 02:39:01',1),('1480437708827951105','<p>sadasd</p>','2022-01-10 01:13:50','2022-01-10 01:13:50',1),('1480438507754774529','<p>哈哈哈哈哈哈哈哈哈哈</p>','2022-01-10 01:17:00','2022-01-10 01:17:00',1),('1481158461152116738','<p>TestDelete</p>','2022-01-12 00:57:50','2022-01-12 00:57:50',1),('1481161462789029890','<p>我爱大乱</p>','2022-01-12 01:09:46','2022-01-12 01:09:46',1),('1483269974700642306','<p>123</p>','2022-01-17 20:48:14','2022-01-17 20:48:14',1),('1484365637194612737','<p>aaa</p>','2022-01-20 21:22:01','2022-01-20 21:22:01',0),('1485917481989591041','<p>1</p>','2022-01-25 04:08:29','2022-01-25 04:08:29',0),('15','','2019-03-13 06:03:33','2022-01-19 00:37:19',0),('18','<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>','2019-03-06 18:06:36','2022-01-07 03:25:01',0);
/*!40000 ALTER TABLE `edu_course_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_subject`
--

DROP TABLE IF EXISTS `edu_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_subject` (
  `id` char(19) NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) NOT NULL COMMENT '类别名称',
  `parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '父ID',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程科目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_subject`
--

LOCK TABLES `edu_subject` WRITE;
/*!40000 ALTER TABLE `edu_subject` DISABLE KEYS */;
INSERT INTO `edu_subject` VALUES ('1178214681118568449','后端开发','0',1,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681139539969','Java','1178214681118568449',1,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681181483010','前端开发','0',3,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681210843137','JavaScript','1178214681181483010',4,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681231814658','云计算','0',5,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681252786178','Docker','1178214681231814658',5,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681294729217','Linux','1178214681231814658',6,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681324089345','系统/运维','0',7,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681353449473','Linux','1178214681324089345',7,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681382809602','Windows','1178214681324089345',8,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681399586817','数据库','0',9,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681428946945','MySQL','1178214681399586817',9,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681454112770','MongoDB','1178214681399586817',10,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681483472898','大数据','0',11,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681504444418','Hadoop','1178214681483472898',11,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681529610242','Spark','1178214681483472898',12,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681554776066','人工智能','0',13,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681584136193','Python','1178214681554776066',13,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681613496321','编程语言','0',14,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178214681626079234','Java','1178214681613496321',14,'2019-09-29 15:47:25','2019-09-29 15:47:25'),('1178585108407984130','Python','1178214681118568449',2,'2019-09-30 16:19:22','2019-09-30 16:19:22'),('1178585108454121473','HTML/CSS','1178214681181483010',3,'2019-09-30 16:19:22','2019-09-30 16:19:22');
/*!40000 ALTER TABLE `edu_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_teacher`
--

DROP TABLE IF EXISTS `edu_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='讲师';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_teacher`
--

LOCK TABLES `edu_teacher` WRITE;
/*!40000 ALTER TABLE `edu_teacher` DISABLE KEYS */;
INSERT INTO `edu_teacher` VALUES ('1','张三','近年主持国家自然科学基金（6项）、江苏省重大科技成果转化项目（5项）、江苏省产学研前瞻性联合研究项目（3项）、省工业科技支撑、省高技术、省自然科学基金等省部级及其企业的主要科研项目40多个，多个项目在企业成功转化，产生了较好的经济、社会和环境效益。积极开展产学研科技合作，并与省内16家企业建立了江苏省研究生工作站，其中6家为江苏省优秀研究生工作站','高级',1,'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg',0,0,'2019-10-30 14:18:46','2019-11-12 13:36:36'),('1189389726308478977','晴天','高级讲师简介','高级讲师资历',2,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/de47ee9b-7fec-43c5-8173-13c5f7f689b2.png',1,0,'2019-10-30 11:53:03','2019-10-30 11:53:03'),('1189390295668469762','李刚','高级讲师简介','高级讲师',2,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/b8aa36a2-db50-4eca-a6e3-cc6e608355e0.png',2,0,'2019-10-30 11:55:19','2019-11-12 13:37:52'),('1189426437876985857','王二','高级讲师简介','高级讲师',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/08/e44a2e92-2421-4ea3-bb49-46f2ec96ef88.png',0,0,'2019-10-30 14:18:56','2019-11-12 13:37:35'),('1189426464967995393','王五','高级讲师简介','高级讲师',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/65423f14-49a9-4092-baf5-6d0ef9686a85.png',0,0,'2019-10-30 14:19:02','2019-11-12 13:37:18'),('1192249914833055746','李四','高级讲师简介','高级讲师',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/07/91871e25-fd83-4af6-845f-ea8d471d825d.png',0,0,'2019-11-07 09:18:25','2019-11-12 13:37:01'),('1192327476087115778','1222-12-12','1111','11',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/08/5805c6cd-c8ad-4a77-aafd-d2e083bfd8a4.png',0,1,'2019-11-07 14:26:37','2019-11-11 16:26:26'),('1195337453429129218','test','sdfsdf','sdfdf',1,'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg',0,1,'2019-11-15 21:47:12','2019-11-15 21:47:27'),('1483645673299091457','elly','唱歌一绝','音乐家',2,'https://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/099d0c5a01e44cbe990bdceb87fd2108file.png',9999,0,'2022-01-18 21:41:08','2022-01-18 21:41:08');
/*!40000 ALTER TABLE `edu_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_video`
--

DROP TABLE IF EXISTS `edu_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程视频';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_video`
--

LOCK TABLES `edu_video` WRITE;
/*!40000 ALTER TABLE `edu_video` DISABLE KEYS */;
INSERT INTO `edu_video` VALUES ('1189476403626409986','18','1181729226915577857','22','5155c73dc112475cbbddccf4723f7cef','视频.mp4',0,0,1,0,'Empty',0,2,'2019-10-30 17:37:29','2022-01-06 03:38:21',0),('1192252824606289921','1192252213659774977','1192252428399751169','第一课时','756cf06db9cb4f30be85a9758b19c645','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,'Empty',0,1,'2019-11-07 09:29:59','2019-11-07 09:29:59',0),('1192628092797730818','1192252213659774977','1192252428399751169','第二课时','2a02d726622f4c7089d44cb993c531e1','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,1,0,'Empty',0,1,'2019-11-08 10:21:10','2019-11-08 10:21:22',0),('1192632495013380097','1192252213659774977','1192252428399751169','第三课时','4e560c892fdf4fa2b42e0671aa42fa9d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,1,0,'Empty',0,1,'2019-11-08 10:38:40','2019-11-08 10:38:40',0),('1194117638832111617','1192252213659774977','1192252428399751169','第四课时','4e560c892fdf4fa2b42e0671aa42fa9d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,'Empty',0,1,'2019-11-12 13:00:05','2019-11-12 13:00:05',0),('1196263770832023554','1192252213659774977','1192252428399751169','第五课时','27d21158b0834cb5a8d50710937de330','eae2b847ef8503b81f5d5593d769dde2.mp4',5,0,0,0,'Empty',0,1,'2019-11-18 11:08:03','2019-11-18 11:08:03',0),('1479388586381533186','18','15','123','',NULL,0,0,0,0,'Empty',0,1,'2022-01-07 03:44:59','2022-01-07 03:44:59',0),('1480438552960983042','1480438507754774529','1480438533407137793','我家阿法','',NULL,0,0,0,0,'Empty',0,1,'2022-01-10 01:17:11','2022-01-10 01:17:11',1),('1480844014135070721','18','1181729226915577857','哈哈啊','b829068e04154f869fe32d762ef43aa2','EllySong.mp4',0,0,0,0,'Empty',0,1,'2022-01-11 04:08:20','2022-01-11 04:08:20',1),('1481142057921167361','18','1181729226915577857','testDelete','ecab4249627447959eed5845607e5194','EllySong.mp4',10,0,0,0,'Empty',0,1,'2022-01-11 23:52:40','2022-01-11 23:52:40',1),('1481158558132813826','1481158461152116738','1481158482379489281','11-1','',NULL,0,0,0,0,'Empty',0,1,'2022-01-12 00:58:14','2022-01-12 00:58:14',1),('1481159074040594434','1481158461152116738','1481158494563942402','123','414e80cec97e4db0b314f8d5ab9b42be','EllySong.mp4',10,0,0,0,'Empty',0,1,'2022-01-12 01:00:17','2022-01-12 01:00:17',1),('1481159152809623553','1481158461152116738','1481158494563942402','121','ba2d7cf9ba30491ca099e76f6e68a02c','EllySong.mp4',11,0,0,0,'Empty',0,1,'2022-01-12 01:00:35','2022-01-12 01:00:35',1),('1481161553885118466','1481161462789029890','1481161494858678274','HHHhh哈哈哈','fff7aa2096344360918c05281290c54b','EllySong.mp4',10,0,0,0,'Empty',0,1,'2022-01-12 01:10:08','2022-01-12 01:10:08',1),('1481161649817239553','1481161462789029890','1481161494858678274','呜呜呜呜好好好','b57fb7f55f144429ba72309068ff5b3a','EllySong.mp4',1,0,0,0,'Empty',0,1,'2022-01-12 01:10:31','2022-01-12 01:10:31',1),('1483270065687678978','1483269974700642306','1483269995420504066','123','73c9ca61fa5546a09615d7719160ef21','EllySong.mp4',10,0,0,0,'Empty',0,1,'2022-01-17 20:48:36','2022-01-17 20:48:36',1),('1483270536473137153','1483269974700642306','1483269995420504066','视频播放小节','e72da2bf278740c2a0b2c6d1303421e0','EllySong.mp4',10,0,0,0,'Empty',0,1,'2022-01-17 20:50:28','2022-01-17 20:50:28',1),('1484365762302312450','1484365637194612737','1484365655787962369','',NULL,'EllySong.mp4',0,0,0,0,'Empty',0,1,'2022-01-20 21:22:31','2022-01-20 21:22:31',1),('1485917712625979394','18','1181729226915577857','',NULL,'EllySong.mp4',0,0,0,0,'Empty',0,1,'2022-01-25 04:09:24','2022-01-25 04:09:24',1),('1485918007091286018','18','1181729226915577857','heloo',NULL,'EllySong.mp4',1,0,0,0,'Empty',0,1,'2022-01-25 04:10:35','2022-01-25 04:10:35',0),('17','18','15','第一节：Java简介','196116a6fee742e1ba9f6c18f65bd8c1','1',1,1000,1,100,'Draft',0,1,'2019-01-01 13:08:57','2019-10-11 11:26:39',1),('18','18','15','第二节：表达式和赋值语句','2d99b08ca0214909899910c9ba042d47','7 - How Do I Find Time for My ',2,999,1,100,'Draft',0,1,'2019-01-01 13:09:02','2019-03-08 03:30:27',1),('19','18','15','第三节：String类','51120d59ddfd424cb5ab08b44fc8b23a','eae2b847ef8503b81f5d5593d769dde2.mp4',3,888,0,100,'Draft',0,1,'2019-01-01 13:09:05','2019-11-12 12:50:45',1),('20','18','15','第四节：程序风格','2a38988892d84df598752226c50f3fa3','00-day10总结.avi',4,666,0,100,'Draft',0,1,'2019-01-01 13:09:05','2019-10-11 09:20:09',1);
/*!40000 ALTER TABLE `edu_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistics_daily`
--

DROP TABLE IF EXISTS `statistics_daily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statistics_daily` (
  `id` char(19) NOT NULL COMMENT '主键',
  `date_calculated` varchar(20) NOT NULL COMMENT '统计日期',
  `register_num` int NOT NULL DEFAULT '0' COMMENT '注册人数',
  `login_num` int NOT NULL DEFAULT '0' COMMENT '登录人数',
  `video_view_num` int NOT NULL DEFAULT '0' COMMENT '每日播放视频数',
  `course_num` int NOT NULL DEFAULT '0' COMMENT '每日新增课程数',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `statistics_day` (`date_calculated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站统计日数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics_daily`
--

LOCK TABLES `statistics_daily` WRITE;
/*!40000 ALTER TABLE `statistics_daily` DISABLE KEYS */;
INSERT INTO `statistics_daily` VALUES ('1483736450486284290','2022-01-19',1,145,180,136,'2022-01-19 17:41:51','2022-01-19 17:41:51'),('1483736471466192898','2022-01-19',0,111,180,145,'2022-01-19 17:41:56','2022-01-19 17:41:56'),('1483978104526864386','2022-01-20',0,139,124,116,'2022-01-20 09:42:06','2022-01-20 09:42:06'),('1483978130095341570','2022-01-20',0,134,141,140,'2022-01-20 09:42:12','2022-01-20 09:42:12'),('1483978138509115393','2022-01-20',0,115,174,148,'2022-01-20 09:42:14','2022-01-20 09:42:14'),('1483978146918694914','2022-01-20',0,108,102,131,'2022-01-20 09:42:16','2022-01-20 09:42:16'),('1484051114894143489','2022-01-20',0,117,173,195,'2022-01-20 14:32:13','2022-01-20 14:32:13'),('1484051146762465282','2022-01-20',0,185,143,192,'2022-01-20 14:32:20','2022-01-20 14:32:20'),('1484051180371423233','2022-01-20',0,154,182,109,'2022-01-20 14:32:28','2022-01-20 14:32:28'),('1484051213917466626','2022-01-20',0,131,126,174,'2022-01-20 14:32:36','2022-01-20 14:32:36'),('1484051247488675842','2022-01-20',0,180,172,145,'2022-01-20 14:32:44','2022-01-20 14:32:44'),('1484051281059885058','2022-01-20',0,100,165,146,'2022-01-20 14:32:52','2022-01-20 14:32:52'),('1484051314639482881','2022-01-20',0,169,160,122,'2022-01-20 14:33:00','2022-01-20 14:33:00'),('1484051348223275010','2022-01-20',0,193,129,118,'2022-01-20 14:33:08','2022-01-20 14:33:08'),('1484051381794484226','2022-01-20',0,111,112,152,'2022-01-20 14:33:16','2022-01-20 14:33:16'),('1484051415416025090','2022-01-20',0,129,163,118,'2022-01-20 14:33:24','2022-01-20 14:33:24'),('1484051448936902658','2022-01-20',0,121,194,141,'2022-01-20 14:33:32','2022-01-20 14:33:32'),('1484051482503917570','2022-01-20',0,153,129,168,'2022-01-20 14:33:40','2022-01-20 14:33:40'),('1484051516100292610','2022-01-20',0,105,185,125,'2022-01-20 14:33:48','2022-01-20 14:33:48'),('1484051549625364482','2022-01-20',0,110,131,118,'2022-01-20 14:33:56','2022-01-20 14:33:56'),('1484051583204962306','2022-01-20',0,189,168,194,'2022-01-20 14:34:04','2022-01-20 14:34:04'),('1484051616784560130','2022-01-20',0,138,198,146,'2022-01-20 14:34:12','2022-01-20 14:34:12'),('1484051650351575041','2022-01-20',0,170,146,143,'2022-01-20 14:34:20','2022-01-20 14:34:20'),('1484051683918589954','2022-01-20',0,141,124,195,'2022-01-20 14:34:28','2022-01-20 14:34:28'),('1484051717485604865','2022-01-20',0,147,152,188,'2022-01-20 14:34:36','2022-01-20 14:34:36'),('1484051751052619777','2022-01-20',0,121,171,136,'2022-01-20 14:34:44','2022-01-20 14:34:44'),('1484051784632217602','2022-01-20',0,117,132,175,'2022-01-20 14:34:52','2022-01-20 14:34:52'),('1484051818186649602','2022-01-20',0,129,161,119,'2022-01-20 14:35:00','2022-01-20 14:35:00'),('1484051851753664513','2022-01-20',0,188,121,123,'2022-01-20 14:35:08','2022-01-20 14:35:08'),('1484051885320679425','2022-01-20',0,114,164,170,'2022-01-20 14:35:16','2022-01-20 14:35:16'),('1484051918908665857','2022-01-20',0,194,163,138,'2022-01-20 14:35:24','2022-01-20 14:35:24'),('1484051952479875074','2022-01-20',0,169,156,125,'2022-01-20 14:35:32','2022-01-20 14:35:32'),('1484051986038501378','2022-01-20',0,149,109,109,'2022-01-20 14:35:40','2022-01-20 14:35:40'),('1484052019622293506','2022-01-20',0,142,148,111,'2022-01-20 14:35:48','2022-01-20 14:35:48'),('1484052053180919810','2022-01-20',0,131,172,129,'2022-01-20 14:35:56','2022-01-20 14:35:56'),('1484052086743740417','2022-01-20',0,100,110,123,'2022-01-20 14:36:04','2022-01-20 14:36:04'),('1484052120314949633','2022-01-20',0,174,188,157,'2022-01-20 14:36:12','2022-01-20 14:36:12'),('1484052153886158849','2022-01-20',0,149,161,182,'2022-01-20 14:36:21','2022-01-20 14:36:21'),('1484052187465756673','2022-01-20',0,151,159,164,'2022-01-20 14:36:29','2022-01-20 14:36:29'),('1484052221020188673','2022-01-20',0,196,177,195,'2022-01-20 14:36:37','2022-01-20 14:36:37'),('1484052254591397890','2022-01-20',0,141,191,133,'2022-01-20 14:36:45','2022-01-20 14:36:45'),('1485628468426825730','2022-01-24',0,123,195,154,'2022-01-24 23:00:03','2022-01-24 23:00:03');
/*!40000 ALTER TABLE `statistics_daily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `course_title` varchar(100) DEFAULT NULL COMMENT '课程名称',
  `course_cover` varchar(255) DEFAULT NULL COMMENT '课程封面',
  `teacher_name` varchar(20) DEFAULT NULL COMMENT '讲师名称',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '会员手机',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '订单金额（分）',
  `pay_type` tinyint DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
  `status` tinyint DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_order_no` (`order_no`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES ('1483684296895578113','20220119141436604','18','Java精品课程','\nhttps://guli-edu-9527.oss-cn-shanghai.aliyuncs.com/2022/01/12409440fa24444287090202783ecbc7JavaAnnotations.jpeg','晴天','1483341562783477761','键委','',0.01,1,1,0,'2022-01-19 14:14:37','2022-01-19 14:14:37');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pay_log`
--

DROP TABLE IF EXISTS `t_pay_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_pay_log` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '支付金额（分）',
  `transaction_id` varchar(30) DEFAULT NULL COMMENT '交易流水号',
  `trade_state` char(20) DEFAULT NULL COMMENT '交易状态',
  `pay_type` tinyint NOT NULL DEFAULT '0' COMMENT '支付类型（1：微信 2：支付宝）',
  `attr` text COMMENT '其他属性',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支付日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pay_log`
--

LOCK TABLES `t_pay_log` WRITE;
/*!40000 ALTER TABLE `t_pay_log` DISABLE KEYS */;
INSERT INTO `t_pay_log` VALUES ('1483681719327997954','20220119140326624','2022-01-19 14:04:22',0.01,'4200001341202201195555134884','SUCCESS',1,'{\"transaction_id\":\"4200001341202201195555134884\",\"nonce_str\":\"gfy9e3DBpTyY9pEz\",\"trade_state\":\"SUCCESS\",\"bank_type\":\"OTHERS\",\"openid\":\"oHwsHuGQmckUCWXQl0GP0dNlJCtU\",\"sign\":\"C3742FB24392591FE8C5BAAF68542FD7\",\"return_msg\":\"OK\",\"fee_type\":\"CNY\",\"mch_id\":\"1558950191\",\"cash_fee\":\"1\",\"out_trade_no\":\"20220119140326624\",\"cash_fee_type\":\"CNY\",\"appid\":\"wx74862e0dfcf69954\",\"total_fee\":\"1\",\"trade_state_desc\":\"支付成功\",\"trade_type\":\"NATIVE\",\"result_code\":\"SUCCESS\",\"attach\":\"\",\"time_end\":\"20220119140419\",\"is_subscribe\":\"N\",\"return_code\":\"SUCCESS\"}',0,'2022-01-19 14:04:22','2022-01-19 14:04:22');
/*!40000 ALTER TABLE `t_pay_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ucenter_member`
--

DROP TABLE IF EXISTS `ucenter_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ucenter_member` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
  `age` tinyint unsigned DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `sign` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ucenter_member`
--

LOCK TABLES `ucenter_member` WRITE;
/*!40000 ALTER TABLE `ucenter_member` DISABLE KEYS */;
INSERT INTO `ucenter_member` VALUES ('1',NULL,'13700000001','96e79218965eb72c92a549dd5a330112','小三123',1,5,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-01 12:11:33','2019-11-08 11:56:01'),('1080736474267144193',NULL,'13700000011','96e79218965eb72c92a549dd5a330112','用户XJtDfaYeKk',1,19,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-02 12:12:45','2019-01-02 12:12:56'),('1080736474355224577',NULL,'13700000002','96e79218965eb72c92a549dd5a330112','用户wUrNkzAPrc',1,27,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-02 12:13:56','2019-01-02 12:14:07'),('1086387099449442306',NULL,'13520191388','96e79218965eb72c92a549dd5a330112','用户XTMUeHDAoj',2,20,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-19 06:17:23','2019-01-19 06:17:23'),('1086387099520745473',NULL,'13520191389','96e79218965eb72c92a549dd5a330112','用户vSdKeDlimn',1,21,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-19 06:17:23','2019-01-19 06:17:23'),('1086387099608825858',NULL,'13520191381','96e79218965eb72c92a549dd5a330112','用户EoyWUVXQoP',1,18,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-19 06:17:23','2019-01-19 06:17:23'),('1086387099701100545',NULL,'13520191382','96e79218965eb72c92a549dd5a330112','用户LcAYbxLNdN',2,24,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-19 06:17:23','2019-01-19 06:17:23'),('1086387099776598018',NULL,'13520191383','96e79218965eb72c92a549dd5a330112','用户dZdjcgltnk',2,25,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-19 06:17:23','2019-01-19 06:17:23'),('1086387099852095490',NULL,'13520191384','96e79218965eb72c92a549dd5a330112','用户wNHGHlxUwX',2,23,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-19 06:17:23','2019-01-19 06:17:23'),('1106746895272849410','o1R-t5u2TfEVeVjO9CPGdHPNw-to',NULL,NULL,'檀梵\'',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/zZfLXcetf2Rpsibq6HbPUWKgWSJHtha9y1XBeaqluPUs6BYicW1FJaVqj7U3ozHd3iaodGKJOvY2PvqYTuCKwpyfQ/132',NULL,0,0,'2019-03-16 10:39:57','2019-03-16 10:39:57'),('1106822699956654081',NULL,NULL,NULL,NULL,NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-03-16 15:41:10','2019-03-16 15:41:10'),('1106823035660357634','o1R-t5i4gENwHYRb5lVFy98Z0bdk',NULL,NULL,'GaoSir',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJI53RcCuc1no02os6ZrattWGiazlPnicoZQ59zkS7phNdLEWUPDk8fzoxibAnXV1Sbx0trqXEsGhXPw/132',NULL,0,0,'2019-03-16 15:42:30','2019-03-16 15:42:30'),('1106823041599492098',NULL,NULL,NULL,NULL,NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-03-16 15:42:32','2019-03-16 15:42:32'),('1106823115788341250','o1R-t5l_3rnbZbn4jWwFdy6Gk6cg',NULL,NULL,'换个网名哇、',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/jJHyeM0EN2jhB70LntI3k8fEKe7W6CwykrKMgDJM4VZqCpcxibVibX397p0vmbKURGkLS4jxjGB0GpZfxCicgt07w/132',NULL,0,0,'2019-03-16 15:42:49','2019-03-16 15:42:49'),('1106826046730227714','o1R-t5gyxumyBqt0CWcnh0S6Ya1g',NULL,NULL,'我是Helen',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKDRfib8wy7A2ltERKh4VygxdjVC1x5OaOb1t9hot4JNt5agwaVLdJLcD9vJCNcxkvQnlvLYIPfrZw/132',NULL,0,0,'2019-03-16 15:54:28','2019-03-16 15:54:28'),('1106828185829490690','o1R-t5nNlou5lRwBVgGNJFm4rbc4',NULL,NULL,' 虎头',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKxCqRzuYWQmpwiaqQEjNxbC7WicebicXQusU306jgmfoOzUcFg1qaDq5BStiblwBjw5dUOblQ2gUicQOQ/132',NULL,0,0,'2019-03-16 16:02:58','2019-03-16 16:02:58'),('1106830599651442689','o1R-t5hZHQB1cbX7HZJsiM727_SA',NULL,NULL,'是吴啊',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9CsqApybcs7f3Dyib9IxIh0sBqJb7LicbjU4WticJFF0PVwFvHgtbFdBwfmk3H2t3NyqmEmVx17tRA/132',NULL,0,0,'2019-03-16 16:12:34','2019-03-16 16:12:34'),('1106830976199278593','o1R-t5meKOoyEJ3-IhWRCBKFcvzU',NULL,NULL,'我才是Helen',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMicP9UT6mVjYWdno0OJZkOXiajG0sllJTbGJ9DYiceej2XvbDSGCK8LCF7jv1PuG2uoYlePWic9XO8A/132',NULL,0,0,'2019-03-16 16:14:03','2019-03-16 16:14:03'),('1106831936900415490','o1R-t5jXYSWakGtnUBnKbfVT5Iok',NULL,NULL,'文若姬',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/3HEmJwpSzguqqAyzmBwqT6aicIanswZibEOicQInQJI3ZY1qmu59icJC6N7SahKqWYv24GvX5KH2fibwt0mPWcTJ3fg/132',NULL,0,0,'2019-03-16 16:17:52','2019-03-16 16:17:52'),('1106832491064442882','o1R-t5sud081Qsa2Vb2xSKgGnf_g',NULL,NULL,'Peanut',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-03-16 16:20:04','2019-03-16 16:20:04'),('1106833021442510849','o1R-t5lsGc3I8P5bDpHj7m_AIRvQ',NULL,NULL,'食物链终结者',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/MQ7qUmCprK9am16M1Ia1Cs3RK0qiarRrl9y8gsssBjIZeS2GwKSrnq7ZYhmrzuzDwBxSMMAofrXeLic9IBlW4M3Q/132',NULL,0,0,'2019-03-16 16:22:11','2019-03-16 16:22:11'),('1191600824445046786',NULL,'15210078344','44f836f42906964f7d659b01d62d19c2f71e38e974e53798','IT妖姬',1,5,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-11-05 14:19:10','2019-11-08 18:04:43'),('1191616288114163713',NULL,'17866603606','96e79218965eb72c92a549dd5a330112','xiaowu',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-11-05 15:20:37','2019-11-05 15:20:37'),('1195187659054329857',NULL,'15010546384','96e79218965eb72c92a549dd5a330112','qy',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-11-15 11:51:58','2019-11-15 11:51:58'),('1482190363397058562',NULL,'11111111','root123123','rawpassword',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2022-01-15 11:18:15','2022-01-15 11:18:15'),('1482193309350301698',NULL,'111','27d37942bf4361c20f045f9d613b6043984297140b315268','hujesse',NULL,NULL,'https://imgconvert.csdnimg.cn/aHR0cDovL3AzLnBzdGF0cC5jb20vbGFyZ2UvcGdjLWltYWdlLzg1MGExZWQxZTFiYTQxNjdhOGZiMmZhYjBiMzQyZjlm',NULL,0,0,'2022-01-15 11:29:57','2022-01-15 11:29:57'),('1482244579960295425',NULL,'17744353485','a6b034c0bf12e9036401667cb76c8de4a13171074fc47a30','ellysong',NULL,NULL,'https://imgconvert.csdnimg.cn/aHR0cDovL3AzLnBzdGF0cC5jb20vbGFyZ2UvcGdjLWltYWdlLzg1MGExZWQxZTFiYTQxNjdhOGZiMmZhYjBiMzQyZjlm',NULL,0,0,'2022-01-15 14:53:41','2022-01-15 14:53:41'),('1483341562783477761','o3_SC55EzrqGjOMBTBTOQievLf1o','',NULL,'键委',NULL,NULL,'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqYSqf77p5KZVjTTzcD68R522dcxckQSAZkRcloqseAdVtnMaRyGXcoZc9A95RUhX98m9haL40djg/132',NULL,0,0,'2022-01-18 15:32:42','2022-01-18 15:32:42');
/*!40000 ALTER TABLE `ucenter_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-13 13:20:16
