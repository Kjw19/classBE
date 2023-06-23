package du.search.classBE.service;

import du.search.classBE.Entity.Hall;
import du.search.classBE.Entity.HallLocationData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassRoomListInsertService {

    private final InitClassroomService initClassroomService;

    @PostConstruct
    public void init() {
        InitClassrooms();
        InitClassroomsWithHallNotExist();
        InitHallLocation();
    }

    public void InitClassrooms() {
        List<String> classroomCodesWithHall = GetClassroomCodesWithHall();
        initClassroomService.insertClassroomsAndHallByHyphen(classroomCodesWithHall);
    }


    public void InitClassroomsWithHallNotExist() {
        List<String> classroomCodesWithoutHall = getClassroomCodesWithoutHall();
        initClassroomService.insertHallNotExistClassroomsByHyphen(classroomCodesWithoutHall);
    }

    public void InitHallLocation() {
        List<HallLocationData> hallLocationDataList = getHallLocationDataList();
        initClassroomService.insertHallLocation(hallLocationDataList);
    }

    private static List<String> getClassroomCodesWithoutHall() {
        List<String> classroomCodesWithoutHall = Arrays.asList(
                "경영대강당동-1PBL2",
                "교수학습-1118D ",
                "교수학습-1118C ",
                "교수학습-1118B ",
                "교수학습-1118A ",
                "교수학습-1112  ",
                "교수학습-1111  ",
                "교수학습-1110  ",
                "교수학습-1108A ",
                "교수학습-1103  ",
                "교수학습-1104  ",
                "교수학습-1107A ",
                "교수학습-1102  ",
                "교수학습-1212  ",
                "교수학습-1213  ",
                "교수학습-1321  ",
                "경영대-1101  ",
                "경영대-1117  ",
                "경영대-1107  ",
                "경영대-1108  ",
                "경영대-1102  ",
                "경영대-1103A ",
                "경영대-1103B ",
                "경영대-1104  ",
                "경영대-1201  ",
                "경영대-1207  ",
                "경영대-1209  ",
                "경영대-1210  ",
                "경영대-1211  ",
                "경영대-1212  ",
                "경영대-1218  ",
                "경영대-1202  ",
                "경영대-1204  ",
                "경영대-1308  ",
                "경영대-1309  ",
                "경영대-1310  ",
                "경영대-1311  ",
                "경영대-1312  ",
                "경영대-1313  ",
                "경영대-1301  ",
                "경영대-1302  ",
                "경영대-1304  ",
                "경영대-1306B ",
                "경영대-1307C ",
                "경영대-1316  ",
                "경영대-1317  ",
                "경영대-1318  ",
                "경영대-1318C ",
                "경영대-1306A ",
                "경영대-1319A ",
                "경영대-1320  ",
                "경영대-1401  ",
                "경영대-1406B ",
                "경영대-1408  ",
                "경영대-1409  ",
                "경영대-1410  ",
                "경영대-1411  ",
                "경영대-1412  ",
                "경영대-1413  ",
                "경영대-1417  ",
                "경영대-1418  ",
                "경영대-1420  ",
                "경영대-1415  ",
                "경영대-1419  ",
                "종합-301",
                "종합-302",
                "종합-303",
                "종합-304",
                "종합-305",
                "종합-201",
                "종합-202",
                "종합-203",
                "종합-101",
                "종합-102",
                "종합-103",
                "종합-104",
                "공과대본-0201 ",
                "공과대본-0202 "
        );
        return classroomCodesWithoutHall;
    }


    private static List<HallLocationData> getHallLocationDataList() {
        return Arrays.asList(
                HallLocationData.builder().buildingName("법행대").hallNumber("1").latitude(35.902732).longitude(128.843718).build(),
                HallLocationData.builder().buildingName("법행대").hallNumber("2").latitude(35.902732).longitude(128.843718).build(),
                HallLocationData.builder().buildingName("인문대").hallNumber("1").latitude(35.898370).longitude(128.850069).build(),
                HallLocationData.builder().buildingName("인문대").hallNumber("2").latitude(35.898851).longitude(128.850305).build(),
                HallLocationData.builder().buildingName("경영대").hallNumber("1").latitude(35.900739).longitude(128.850875).build(),
                HallLocationData.builder().buildingName("경영대").hallNumber("0").latitude(35.900817).longitude(128.851629).build(),
                HallLocationData.builder().buildingName("종합").hallNumber("0").latitude(35.901915).longitude(128.842684).build(),
                HallLocationData.builder().buildingName("사과대").hallNumber("1").latitude(35.901331).longitude(128.842803).build(),
                HallLocationData.builder().buildingName("사과대").hallNumber("2").latitude(35.901271).longitude(128.842237).build(),
                HallLocationData.builder().buildingName("과생대").hallNumber("1").latitude(35.899084).longitude(128.848248).build(),
                HallLocationData.builder().buildingName("과생대").hallNumber("2").latitude(35.899449).longitude(128.848417).build(),
                HallLocationData.builder().buildingName("과생대").hallNumber("3").latitude(35.899793).longitude(128.848404).build(),
                HallLocationData.builder().buildingName("공과대").hallNumber("0").latitude(35.899120).longitude(128.855212).build(),
                HallLocationData.builder().buildingName("공과대").hallNumber("1").latitude(35.899088).longitude(128.855723).build(),
                HallLocationData.builder().buildingName("공과대").hallNumber("2").latitude(35.899094).longitude(128.854603).build(),
                HallLocationData.builder().buildingName("공과대").hallNumber("3").latitude(35.899606).longitude(128.855593).build(),
                HallLocationData.builder().buildingName("정통대").hallNumber("1").latitude(35.899672).longitude(128.854717).build(),
                HallLocationData.builder().buildingName("공과대").hallNumber("6").latitude(35.900154).longitude(128.855555).build(),
                HallLocationData.builder().buildingName("정통대").hallNumber("2").latitude(35.900190).longitude(128.854593).build(),
                HallLocationData.builder().buildingName("교수학습").hallNumber("0").latitude(35.899707).longitude(128.850518).build(),
                HallLocationData.builder().buildingName("과생대").hallNumber("5").latitude(35.902864).longitude(128.855936).build(),
                HallLocationData.builder().buildingName("과생대").hallNumber("6").latitude(35.902201).longitude(128.857101).build(),
                HallLocationData.builder().buildingName("조예대").hallNumber("1").latitude(35.902320).longitude(128.844717).build(),
                HallLocationData.builder().buildingName("조예대").hallNumber("2").latitude(35.903086).longitude(128.845753).build(),
                HallLocationData.builder().buildingName("조예대").hallNumber("3").latitude(35.903054).longitude(128.846160).build(),
                HallLocationData.builder().buildingName("조예대").hallNumber("5").latitude(35.898831).longitude(128.846998).build(),
                HallLocationData.builder().buildingName("사범대").hallNumber("1").latitude(35.900184).longitude(128.846475).build(),
                HallLocationData.builder().buildingName("사범대").hallNumber("2").latitude(35.900479).longitude(128.845679).build(),
                HallLocationData.builder().buildingName("재과대").hallNumber("1").latitude(35.899900).longitude(128.853181).build(),
                HallLocationData.builder().buildingName("재과대").hallNumber("2").latitude(35.900389).longitude(128.851490).build()
        );
    }
    private static List<String> GetClassroomCodesWithHall() {
        List<String> classroomCodesWithHall = Arrays.asList(

                "법행대1-1112 ",
                "법행대1-1104 ",
                "법행대1-1106 ",
                "법행대1-1102 ",
                "법행대1-1110 ",
                "법행대1-1109 ",
                "법행대1-1114 ",
                "법행대1-1115 ",
                "법행대1-1205 ",
                "법행대1-1206 ",
                "법행대1-1217 ",
                "법행대1-1218 ",
                "법행대1-1302 ",
                "법행대1-1306 ",
                "법행대1-1309 ",
                "법행대1-1310 ",
                "법행대1-1313 ",
                "법행대1-1314 ",
                "법행대1-1314 ",
                "법행대1-1316 ",
                "법행대1-1317 ",
                "법행대2-2301 ",
                "법행대2-2302 ",
                "법행대2-2303 ",
                "법행대2-2304 ",
                "법행대2-2305 ",
                "법행대2-2401 ",
                "법행대2-2402 ",
                "조예대1-1102B",
                "조예대1-1102A",
                "조예대1-1101A",
                "조예대1-1101B",
                "조예대1-1101C",
                "조예대1-1101D",
                "조예대1-1101 ",
                "조예대1-1101E",
                "조예대1-1103 ",
                "조예대1-1104 ",
                "조예대1-1109 ",
                "조예대1-1108 ",
                "조예대1-1107 ",
                "조예대1-1112 ",
                "조예대1-1112B",
                "조예대1-1113A",
                "조예대1-1113B",
                "조예대1-1113C",
                "조예대1-1114 ",
                "조예대1-1308A",
                "조예대1-1308B",
                "조예대1-1307 ",
                "조예대1-1310A",
                "조예대1-1311A",
                "조예대1-1311 ",
                "조예대1-1312B",
                "조예대1-1312A",
                "조예대1-1302 ",
                "조예대1-1303 ",
                "조예대1-1301 ",
                "조예대1-1402 ",
                "조예대1-1403 ",
                "조예대1-1401 ",
                "조예대1-1404 ",
                "조예대1-1413 ",
                "조예대1-1412B",
                "조예대1-1407 ",
                "조예대1-1412A",
                "조예대1-1141 ",
                "조예대1-1202 ",
                "조예대1-1201 ",
                "조예대1-1219 ",
                "조예대1-1218 ",
                "조예대1-1217 ",
                "조예대1-1216 ",
                "조예대5-1111 ",
                "조예대5-1116 ",
                "조예대5-1113A",
                "조예대5-1113B",
                "조예대5-1108A",
                "조예대5-1108B",
                "조예대5-1107 ",
                "조예대5-1106B",
                "조예대5-1106A",
                "조예대5-1101 ",
                "조예대5-1115 ",
                "조예대5-1219A",
                "조예대5-1218 ",
                "조예대5-1217 ",
                "조예대5-1216 ",
                "조예대5-1211A",
                "조예대5-1210 ",
                "조예대5-1209A",
                "조예대5-1208A",
                "조예대5-1208B",
                "조예대5-1207 ",
                "조예대5-1201 ",
                "조예대5-1202 ",
                "조예대5-1203 ",
                "조예대5-1204 ",
                "조예대5-1205 ",
                "조예대5-1318A",
                "조예대5-1317 ",
                "조예대5-1316 ",
                "조예대5-1310 ",
                "조예대5-1309 ",
                "조예대5-1308 ",
                "조예대5-1312 ",
                "조예대5-1314 ",
                "조예대5-1301 ",
                "조예대5-1302 ",
                "조예대5-1303 ",
                "조예대5-1304 ",
                "조예대5-1331 ",
                "조예대5-1330 ",
                "조예대5-1327 ",
                "사과대1-1203 ",
                "사과대1-1204 ",
                "사과대1-1205 ",
                "사과대1-1206 ",
                "사과대1-1207 ",
                "사과대1-1212 ",
                "사과대1-1301 ",
                "사과대1-1302 ",
                "사과대1-1303 ",
                "사과대1-1304 ",
                "사과대1-1305 ",
                "사과대1-1305A",
                "사과대1-1306 ",
                "사과대1-1307A",
                "사과대1-1310 ",
                "사과대1-1313B",
                "사과대1-1314 ",
                "사과대1-1401 ",
                "사과대1-1402 ",
                "사과대1-1403 ",
                "사과대1-1404 ",
                "사과대1-1405 ",
                "사과대1-1406 ",
                "사과대1-1407 ",
                "사과대1-1410 ",
                "사과대1-1411 ",
                "사과대1-1501 ",
                "사과대1-1502A",
                "사과대1-1502B",
                "사과대1-1503 ",
                "사과대1-1504 ",
                "사과대1-1507 ",
                "사과대2-2103A",
                "사과대2-2103B",
                "사과대2-2104 ",
                "사과대2-2104B",
                "사과대2-2105A",
                "사과대2-2105B",
                "사과대2-2106 ",
                "사과대2-2107 ",
                "사과대2-2108 ",
                "사과대2-2109 ",
                "사과대2-2110A",
                "사과대2-2110B",
                "사과대2-2111A",
                "사과대2-2111B",
                "사과대2-2120 ",
                "사과대2-2202 ",
                "사과대2-2208B",
                "사과대2-2303 ",
                "사과대2-2304 ",
                "사과대2-2305 ",
                "사과대2-2306 ",
                "사과대2-2307 ",
                "사과대2-2308 ",
                "사과대2-2309A",
                "사과대2-2309B",
                "사과대2-2402A",
                "사과대2-2402B",
                "사과대2-2402C",
                "사과대2-2403 ",
                "사과대2-2404A",
                "사과대2-2404B",
                "사과대2-2405A",
                "사과대2-2405B",
                "사과대2-2407 ",
                "사과대2-2408B",
                "사범대1-1119 ",
                "사범대1-1120 ",
                "사범대1-1121 ",
                "사범대1-1122 ",
                "사범대1-1123 ",
                "사범대1-1124 ",
                "사범대1-1210 ",
                "사범대1-1211 ",
                "사범대1-1212 ",
                "사범대1-1213 ",
                "사범대1-1214 ",
                "사범대1-1215 ",
                "사범대1-1216 ",
                "사범대1-1217 ",
                "사범대1-1333 ",
                "사범대1-1334 ",
                "사범대1-1335 ",
                "사범대1-1336 ",
                "사범대1-1337 ",
                "사범대1-1338 ",
                "사범대1-1339 ",
                "사범대1-1340 ",
                "사범대1-1429 ",
                "사범대1-1430 ",
                "사범대1-1431 ",
                "사범대1-1432 ",
                "사범대1-1433 ",
                "사범대1-1434 ",
                "사범대1-1435 ",
                "사범대1-1436 ",
                "사범대2-2202 ",
                "과생대1-1104 ",
                "과생대1-1111 ",
                "과생대1-1108 ",
                "과생대1-1109 ",
                "과생대1-1217 ",
                "과생대1-1206 ",
                "과생대1-1208 ",
                "과생대1-1211 ",
                "과생대1-1309 ",
                "과생대1-1310 ",
                "과생대1-1313 ",
                "과생대1-1315 ",
                "과생대1-1212 ",
                "과생대1-1215 ",
                "과생대1-1403 ",
                "과생대1-1405 ",
                "과생대1-1410 ",
                "과생대1-1412 ",
                "과생대1-1414 ",
                "과생대1-1402 ",
                "과생대2-1강당 ",
                "과생대2-1102 ",
                "과생대2-1104 ",
                "과생대2-1202A",
                "과생대2-1202C",
                "과생대2-1203 ",
                "과생대2-1204 ",
                "과생대2-1206 ",
                "과생대2-1303 ",
                "과생대2-1302 ",
                "과생대2-1305 ",
                "과생대2-1306 ",
                "과생대2-1315 ",
                "과생대2-1403 ",
                "과생대2-1404 ",
                "과생대3-1213 ",
                "과생대3-1212 ",
                "과생대3-1211 ",
                "과생대3-1203 ",
                "과생대3-1312 ",
                "과생대3-1311 ",
                "과생대3-1310 ",
                "과생대3-1309A",
                "과생대3-1303 ",
                "과생대3-2113A",
                "과생대3-2113B",
                "과생대3-2105 ",
                "과생대3-2112 ",
                "과생대3-2109 ",
                "과생대3-2108 ",
                "과생대3-2214 ",
                "과생대3-2212 ",
                "과생대3-2109 ",
                "과생대3-2108 ",
                "과생대3-2214 ",
                "과생대3-2212 ",
                "과생대3-2204 ",
                "과생대3-2211 ",
                "과생대3-2208 ",
                "과생대3-2214 ",
                "과생대3-2212 ",
                "과생대3-2204 ",
                "과생대3-2211 ",
                "과생대3-2208 ",
                "과생대3-2207 ",
                "과생대3-2304 ",
                "과생대3-2312 ",
                "과생대3-2314 ",
                "과생대3-2311 ",
                "과생대3-3116 ",
                "과생대3-3115 ",
                "과생대3-3105 ",
                "과생대3-3215 ",
                "과생대3-3214 ",
                "과생대3-3304 ",
                "과생대5-1118 ",
                "과생대5-1116 ",
                "과생대5-1111 ",
                "과생대5-1115 ",
                "과생대5-1119A",
                "과생대5-1121 ",
                "과생대5-1120 ",
                "과생대5-1204 ",
                "과생대5-1208 ",
                "과생대5-1210 ",
                "과생대5-1212 ",
                "과생대5-1213 ",
                "과생대5-1215 ",
                "과생대5-1214 ",
                "과생대5-1220 ",
                "과생대5-1202 ",
                "과생대5-1203 ",
                "과생대5-1205 ",
                "과생대5-1223 ",
                "과생대5-1302 ",
                "과생대5-1309 ",
                "과생대5-1310A",
                "과생대5-1311 ",
                "과생대5-1303 ",
                "과생대5-1304 ",
                "과생대5-1305 ",
                "과생대5-1306 ",
                "과생대5-1305 ",
                "과생대5-1406B",
                "과생대5-1405 ",
                "과생대5-1410 ",
                "과생대6-2101A",
                "과생대6-2101B",
                "과생대6-2102 ",
                "과생대6-2103 ",
                "과생대6-2108 ",
                "과생대6-2110 ",
                "과생대6-2115 ",
                "과생대6-2116 ",
                "과생대6-2121 ",
                "과생대6-2122 ",
                "과생대6-2203F",
                "과생대6-2208 ",
                "과생대6-2209 ",
                "과생대6-2210 ",
                "과생대6-2213 ",
                "과생대6-2216 ",
                "과생대6-2219 ",
                "과생대6-2304 ",
                "과생대6-2320 ",
                "과생대6-2314C",
                "과생대6-1316 ",
                "과생대6-1219 ",
                "과생대6-2303A",
                "과생대6-2303B",
                "과생대6-2412 ",
                "과생대6-2413 ",
                "과생대7-1102 ",
                "과생대7-1103 ",
                "과생대7-1104 ",
                "과생대7-1105 ",
                "과생대7-1106 ",
                "재과대1-1104 ",
                "재과대1-1212 ",
                "재과대1-1213 ",
                "재과대1-1214 ",
                "재과대1-1215 ",
                "재과대1-1211 ",
                "재과대1-1207 ",
                "재과대1-1208 ",
                "재과대1-1209 ",
                "재과대1-1210 ",
                "재과대1-1315 ",
                "재과대1-1316 ",
                "재과대1-1414 ",
                "재과대1-1415 ",
                "재과대1-1416 ",
                "재과대2-1305 ",
                "재과대2-1303 ",
                "인문대1-1109 ",
                "인문대1-1113 ",
                "인문대1-1106 ",
                "인문대1-1105 ",
                "인문대1-1104 ",
                "인문대1-1103 ",
                "인문대1-1101 ",
                "인문대1-1207 ",
                "인문대1-1205 ",
                "인문대1-1203 ",
                "인문대1-1201 ",
                "인문대1-1224A",
                "인문대1-1224 ",
                "인문대1-1219 ",
                "인문대1-1218 ",
                "인문대1-1217 ",
                "인문대1-1220 ",
                "인문대1-1221 ",
                "인문대1-1307 ",
                "인문대1-1311 ",
                "인문대1-1305 ",
                "인문대1-1304 ",
                "인문대1-1301 ",
                "인문대1-1325 ",
                "인문대1-1324 ",
                "인문대1-1319 ",
                "인문대1-1318 ",
                "인문대1-1317 ",
                "인문대1-1320 ",
                "인문대1-1321 ",
                "인문대1-1322 ",
                "인문대1-1408 ",
                "인문대1-1407 ",
                "인문대1-1406 ",
                "인문대1-1411 ",
                "인문대1-1401 ",
                "인문대1-1429 ",
                "인문대1-1428 ",
                "인문대1-1421 ",
                "인문대1-1420 ",
                "인문대1-1419 ",
                "인문대1-1418 ",
                "인문대1-1417 ",
                "인문대1-1422 ",
                "인문대1-1423 ",
                "인문대1-1424 ",
                "인문대1-1425 ",
                "인문대1-1426 ",
                "인문대1-1427 ",
                "인문대2-2203A",
                "인문대2-2203 ",
                "인문대2-2202 ",
                "인문대2-2201 ",
                "인문대2-2304 ",
                "인문대2-2303 ",
                "인문대2-2302 ",
                "인문대2-2301 ",
                "인문대2-2105 ",
                "인문대2-2104 ",
                "인문대2-2103 ",
                "인문대2-2102B",
                "인문대2-2104A",
                "인문대2-2101 ",
                "인문대2-2404 ",
                "인문대2-2403 ",
                "인문대2-2402 ",
                "인문대2-2401 ",
                "공과대1-1319 ",
                "공과대1-1328 ",
                "공과대1-1329 ",
                "공과대1-1428B",
                "공과대1-1517A",
                "공과대1-1519 ",
                "공과대1-1520 ",
                "공과대1-1514B",
                "공과대1-1601A",
                "공과대1-1608B",
                "공과대2-2101 ",
                "공과대2-2112 ",
                "공과대2-2201 ",
                "공과대2-2212 ",
                "공과대2-2301 ",
                "공과대2-2312 ",
                "공과대2-2309A",
                "공과대2-2401 ",
                "공과대2-2412 ",
                "공과대2-2501 ",
                "공과대2-2510 ",
                "공과대3-3217 ",
                "공과대3-3313 ",
                "공과대3-3316 ",
                "공과대3-3422 ",
                "공과대3-3513 ",
                "공과대3-3614 ",
                "공과대3-3616 ",
                "공과대3-3713 ",
                "공과대6-6409 ",
                "공과대6-6410 ",
                "공과대6-6411B",
                "공과대6-6508 ",
                "공과대6-6513 ",
                "정통대1-5102 ",
                "정통대1-5103 ",
                "정통대1-5104 ",
                "정통대1-5105 ",
                "정통대1-5106 ",
                "정통대1-5107 ",
                "정통대1-5205 ",
                "정통대1-5206 ",
                "정통대1-5305 ",
                "정통대1-5306 ",
                "정통대2-7102A",
                "정통대2-7205 ",
                "정통대2-7206 ",
                "정통대2-7207 ",
                "정통대2-7208 ",
                "정통대2-7305 ",
                "정통대2-7306 ",
                "정통대2-7307 ",
                "정통대2-7405 ",
                "정통대2-7406 ",
                "정통대2-7407 ",
                "정통대2-7408 ",
                "정통대2-7409 ",
                "정통대2-7418 ",
                "정통대2-7514 ",
                "정통대2-7506 ",
                "정통대2-7507B",
                "정통대2-7507A",
                "정통대2-7615 ",
                "정통대2-7605 ",
                "정통대2-7606 ",
                "정통대2-7607 ",
                "정통대2-7714 ",
                "정통대2-7705A",
                "정통대2-7705B",
                "정통대2-7706 ",
                "정통대2-7707 "
        );
        return classroomCodesWithHall;
    }

    }
