CREATE (Zaragoza:City {name:'Zaragoza'})
CREATE (Tarragona:City {name:'Tarragona'})
CREATE (Barcelona:City {name:'Barcelona'})
CREATE (Andorra:City {name:'Andorra'})
CREATE (Pamplona:City {name:'Pamplona'})
CREATE (Bilbao:City {name:'Bilbao'})
CREATE (Santander:City {name:'Santander'})
CREATE (Somo:City {name:'Somo'})
CREATE (Valladolid:City {name:'Valladolid'})
CREATE (Madrid:City {name:'Madrid'})
CREATE (Toledo:City {name:'Toledo'})
CREATE (Murcia:City {name:'Murcia'})
CREATE (Valencia:City {name:'Valencia'})
CREATE (Sevilla:City {name:'Sevilla'})
CREATE (Huelva:City {name:'Huelva'})

CREATE (Zaragoza)-[:CONNECTED_TO { departureTime: time({hour:9, minute:10, second:00}), arrivalTime:time({hour:13, minute:00, second:00}) }]->(Barcelona)

CREATE (Zaragoza)-[:CONNECTED_TO { departureTime: time({hour:8, minute:00, second:00}), arrivalTime:time({hour:10, minute:25, second:00}) }]->(Tarragona)
CREATE (Tarragona)-[:CONNECTED_TO { departureTime: time({hour:11, minute:10, second:00}), arrivalTime:time({hour:12, minute:30, second:00}) }]->(Barcelona)

CREATE (Zaragoza)-[:CONNECTED_TO { departureTime: time({hour:15, minute:00, second:00}), arrivalTime:time({hour:18, minute:25, second:00}) }]->(Valencia)
CREATE (Valencia)-[:CONNECTED_TO { departureTime: time({hour:20, minute:00, second:00}), arrivalTime:time({hour:23, minute:45, second:00}) }]->(Barcelona)

CREATE (Andorra)-[:CONNECTED_TO { departureTime: time({hour:15, minute:00, second:00}), arrivalTime:time({hour:21, minute:10, second:00}) }]->(Bilbao)
CREATE (Bilbao)-[:CONNECTED_TO { departureTime: time({hour:15, minute:00, second:00}), arrivalTime:time({hour:21, minute:10, second:00}) }]->(Santander)


CREATE (Andorra)-[:CONNECTED_TO { departureTime: time({hour:15, minute:00, second:00}), arrivalTime:time({hour:21, minute:10, second:00}) }]->(Pamplona)
CREATE (Pamplona)-[:CONNECTED_TO { departureTime: time({hour:15, minute:00, second:00}), arrivalTime:time({hour:21, minute:10, second:00}) }]->(Bilbao)

CREATE (Santander)-[:CONNECTED_TO { departureTime: time({hour:18, minute:00, second:00}), arrivalTime:time({hour:18, minute:30, second:00}) }]->(Somo)


CREATE (Valencia)-[:CONNECTED_TO { departureTime: time({hour:10, minute:00, second:00}), arrivalTime:time({hour:12, minute:33, second:00}) }]->(Murcia)
CREATE (Murcia)-[:CONNECTED_TO { departureTime: time({hour:16, minute:22, second:00}), arrivalTime:time({hour:19, minute:28, second:00}) }]->(Madrid)
CREATE (Valencia)-[:CONNECTED_TO { departureTime: time({hour:11, minute:20, second:00}), arrivalTime:time({hour:15, minute:55, second:00}) }]->(Madrid)

