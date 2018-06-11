package com.huangj.advance.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author huangj
 * @Description:  Redis 配置类
 * 备注：该项目 Redis 的 key 规定为 String类型，value 已经做了 转json 的序列化
 * @date 2018/6/11
 */
@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.redis.database}")
	private int database;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.pool.max-active}")
	private int maxActive;

	@Value("${spring.redis.pool.max-wait}")
	private int maxWait;

	@Value("${spring.redis.pool.min-idle}")
	private int minIdle;

	/**
	 * JedisPoolConfig 连接池 配置
	 * todo 详细配置后面再了解
	 * @return
	 */
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 最大空闲数
		jedisPoolConfig.setMaxIdle(8);
		// 最大建立连接等待时间
		jedisPoolConfig.setMaxWaitMillis(maxWait);
		// 最小能够保持idle状态的对象数
		jedisPoolConfig.setMinIdle(minIdle);
		jedisPoolConfig.setTestOnBorrow(true);
		jedisPoolConfig.setTestOnCreate(true);
		jedisPoolConfig.setTestWhileIdle(true);
		return jedisPoolConfig;
	}

	/**
	 * RedisConnectionFactory 配置
	 * todo 详细配置后面再了解
	 * @param jedisPoolConfig
	 * @return
	 */
	@Bean
	public RedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
		// redis 主机地址
		jedisConnectionFactory.setHostName(host);
		// redis 主机端口号
		jedisConnectionFactory.setPort(port);
		// redis 密码
		if(StringUtils.isNotBlank(password)){
			jedisConnectionFactory.setPassword(password);
		}
		// redis 默认有16个数据库，默认指定其中一个
		jedisConnectionFactory.setDatabase(database);
		// 客户端超时设置(时间单位是毫秒)
		jedisConnectionFactory.setTimeout(timeout);
		return jedisConnectionFactory;
	}

	/**
	 * 实例化 RedisTemplate 对象
	 * 备注：序列化方式也可以自定义，Sinter 项目中通过将对象转为 JSON 在存储到 redis，
	 * 只使用到了 StringRedisSerializer 序列化器
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		// 设置 key 和 value 的序列化方式
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		// 开启事务
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}

}



















