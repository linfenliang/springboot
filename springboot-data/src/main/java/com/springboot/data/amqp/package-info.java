/**
 * 该目录为AMQP的RabbitMQ的实现的测试，用于验证RabbitMQ是否满足业务需求
 * 需求如下：
 * 部分企业无公网IP地址（或不开放），导致数据节点无法通过HTTP实时推送，故采用消息对接的方式，由企业进行订阅，然后进行推送
 * 
 * 设计方案：
 * 1、不同的企业建立不同的消息对列queue，queue的名字为
 * 2、同一家企业的不同业务推送共用相同的queue
 * 3、实时推送数据产生后，根据exchange（以企业ID判断设计）转发给不同的queue
 * 
 */
/**
 * @author linfenliang
 *
 */
package com.springboot.data.amqp;