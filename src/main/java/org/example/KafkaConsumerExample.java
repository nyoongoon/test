package org.example.chapter02;

public class KafkaConsumerExample {
    private static final String TOPIC_NAME = "my-topic";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USERNAME = "myuser";
    private static final String DB_PASSWORD = "mypassword";

    public static void main(String[] args) {

        // Kafka Consumer 설정
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("group.id", "test-group");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 토픽 구독
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        // 데이터 저장
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    String data = record.value();

                    // 데이터 저장
                    String sql = "INSERT INTO";
                    


}
