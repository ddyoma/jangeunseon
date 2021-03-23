package test;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import com.test.sp1.entity.Item;
import com.test.sp1.entity.*;

public class XMLConvertor {
	public static void main(String[] args) {
		String xml = "<response>\r\n" + "<header>\r\n" + "<resultCode>0000</resultCode>\r\n"
				+ "<resultMsg>OK</resultMsg>\r\n" + " </header>\r\n" + "<body>\r\n" + "<items>\r\n" + "<item>\r\n"
				+ "<affiliation>China Film Media Asia Audio Video Distribution Co.,Media Asia Films</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n"
				+ "<contributor>각본:우웨이룬,임초현||배급사:(주)미디어데이</contributor>\r\n" + "<createdDate>2010</createdDate>\r\n"
				+ "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :각자 다른 복수를 꿈꾸는 두 남자 인생을 건 마지막 대결은 이제부터 시작이다! 예기치 못한 사고로 소매치기에 아내를 잃은 베테랑 형사 '원팡'(여명) 그리고 출세를 위해 부단히 노력하지만 자신을 둘러싼 여러 장애물 때문에 진급에 한계를 느끼고 점점 비리 경찰로 변해가는 형사 '지반장'(임현제) 한 남자는 죽은 아내의 복수만을 생각하고 다른 한 남자는 자신의 출세를 막은 사람들에 대한 복수를 꿈꾸며 각자 다른 목표를 가지고 그 하나만을 이루기 위해 살아가고 있다. 그러던 어느 날 둘은 숙명처럼 하나의 사건에 얽히게 된다. 과연 이 두 남자의 운명은 어떤 결과를 가져올 것인가…</description>\r\n"
				+ "<extent>상영시간 : 106</extent>\r\n" + "<format>Video</format>\r\n"
				+ "<grade>관리등급 : 18세관람가(청소년관람불가)</grade>\r\n" + "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n"
				+ "<language>kor</language>\r\n" + "<person>출연 : 여명,임현제,왕보강,비비안 수,요계지</person>\r\n"
				+ "<publisher>KFAC04</publisher>\r\n" + "<regDate>2010-08-02T16:36:51+09:00</regDate>\r\n"
				+ "<rights>임초현</rights>\r\n" + "<rn>1</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26727제목 : 화룡대결제작년도 : 2010영문명 : 제작국가 : 홍콩감독 : 임초현제작사 : China Film Media Asia Audio Video Distribution Co.,Media Asia Films영화심의여부 : Y대표심의일 : 20131126대표심의번호 : 2013-MF00856 대표개봉일 : 20140109최종 업데이트일 :19-SEP-16</subDescription>\r\n"
				+ "<subjectCategory>장르 : 액션,스릴러</subjectCategory>\r\n"
				+ "<subjectKeyword>형사,DNA,살인사건,수사,음모,홍콩경찰</subjectKeyword>\r\n" + "<title>화룡대결</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026727</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n" + "<affiliation>VERTIGO FILMS</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n"
				+ "<contributor>각본:가렛 에드워즈||배급사:씨네그루㈜다우기술</contributor>\r\n" + "<createdDate>2010</createdDate>\r\n"
				+ "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :'괴물'이라 일컬어지는 거대 괴생명체의 등장! 격리된 감염구역을 벗어나기 위한 두 남녀의 위험한 횡단이 시작된다. 2009년, 태양계에서 외계생명체의 존재가능성을 발견한 우주 탐사선이 외계 샘플을 채취해 지구로 귀화하던 중 멕시코에 추락하는 사건이 발생한다. 이 후 나타나기 시작한 괴생명체로 인해 나라의 절반이 감염구역으로 지정되어 격리되고. 그로부터 6년 후. 삼류 사진가 '앤드류'(스쿳 맥네이리)는 멕시코 인근으로 여행을 떠난 출판사 사장의 딸 '샘'(휘트니 에이블)을 집까지 안전하게 데려오라는 임무를 맡는다. 샘과 함께 크루즈를 타고 미국으로 오는 간단한 임무로 시작된 그들의 여정은 여권을 도둑 맞으며 크루즈에 오르지 못하고, 어떻게든 미국으로 돌아가야 하는 상황에서 감염구역의 중심을 지나가야 하는 최악의 위기를 맞는다. 무방비 상태로 감염구역을 지나가던 그들은 '괴생명체'와 맞닥뜨리게 되는데…</description>\r\n"
				+ "<extent>상영시간 : 91</extent>\r\n" + "<format>Video</format>\r\n" + "<grade>관리등급 : 15세관람가</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 휘트니 에이블,스코트 맥네어리</person>\r\n" + "<publisher>KFAC04</publisher>\r\n"
				+ "<regDate>2010-08-02T16:44:28+09:00</regDate>\r\n" + "<rights>가렛 에드워즈</rights>\r\n" + "<rn>2</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26728제목 : 몬스터즈제작년도 : 2010영문명 : 제작국가 : 영국감독 : 가렛 에드워즈제작사 : VERTIGO FILMS영화심의여부 : Y대표심의일 : 20140527대표심의번호 : 2014-MF00580대표개봉일 : 20140529최종 업데이트일 :29-MAY-14</subDescription>\r\n"
				+ "<subjectCategory>장르 : 멜로드라마,SF</subjectCategory>\r\n"
				+ "<subjectKeyword>괴생명체,괴물,감염,남녀,외계생명체</subjectKeyword>\r\n" + "<title>몬스터즈</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026728</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n" + "<affiliation>SUNRISE</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n" + "<contributor>각본:야마토야 아카츠키||배급사:</contributor>\r\n"
				+ "<createdDate>2010</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :외계 침략으로 사무라이와 인터넷이 공존하는 에도시대. 해결사 사무소를 운영하는 긴토키에게 도난당한 검을 찾아달라는 의뢰가 들어오면서 이야기는 시작된다. 시대물, SF, 사무라이 액션, 코메디 등을 넘나드는 스토리와 별난 캐릭터들에 적응될 때 즈음이면 어느새 진지하고도 인간적인 &lt;은혼&gt;의 매력에 빠져들게 된다. 시리즈 중 최고의 에피소드로 평가받는 ‘홍앵’ 편이 첫 극장판으로 채택되었다.</description>\r\n"
				+ "<extent>상영시간 : 96</extent>\r\n" + "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 :</person>\r\n" + "<publisher>KFAC04</publisher>\r\n"
				+ "<regDate>2010-08-02T16:30:25+09:00</regDate>\r\n" + "<rights>타카마츠 신지</rights>\r\n" + "<rn>3</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26726제목 : 극장판 은혼: 신역홍앵편제작년도 : 2010영문명 : 제작국가 : 일본감독 : 타카마츠 신지제작사 : SUNRISE영화심의여부 : 대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :15-NOV-17</subDescription>\r\n"
				+ "<subjectCategory>장르 : 액션,시대극/사극,코메디,SF</subjectCategory>\r\n" + "<title>극장판 은혼: 신역홍앵편</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026726</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n" + "<affiliation>Films Sonores Tobis,Cineas</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n" + "<contributor>각본:샤샤 기트리||배급사:</contributor>\r\n"
				+ "<createdDate>1937</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :&lt;꿈을 꾸다&gt;는 사샤 기트리가 1916년 무대 위에서 초연한 후 20년이 지나 본인이 직접 시나리오를 각색하고 연출하고 직접 연기까지 한 작품이다. 사샤 기트리의 실제 부인 재클린 데루박이 극 중 사랑에 빠진 부인 역을 맡아 모노로그에 가까운 열연을 펼친다. 사샤 기트리가 세상을 역설적으로 바라보는 시각을 느낄 수 있는 작품이다. (서울아트시네마)</description>\r\n"
				+ "<extent>상영시간 : 86</extent>\r\n" + "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 사샤 기트리,레뮈,재클린 델루박,아레티,루이스 바론 필,피에르 베르틴,빅터 부셰</person>\r\n"
				+ "<publisher>KFAC04</publisher>\r\n" + "<regDate>2010-08-27T11:38:31+09:00</regDate>\r\n"
				+ "<rights>사샤 기트리</rights>\r\n" + "<rn>4</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26814제목 : 꿈을 꾸다제작년도 : 1937영문명 : 제작국가 : 프랑스감독 : 사샤 기트리제작사 : Films Sonores Tobis,Cineas영화심의여부 : 대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :07-OCT-11</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디</subjectCategory>\r\n" + "<title>꿈을 꾸다</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026814</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n"
				+ "<affiliation>Societe dExploitation et de Distribution de Films (SEDIF)</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n" + "<contributor>각본:샤샤 기트리||배급사:</contributor>\r\n"
				+ "<createdDate>1938</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :</description>\r\n" + "<extent>상영시간 :</extent>\r\n" + "<format>Video</format>\r\n"
				+ "<grade>관리등급 :</grade>\r\n" + "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n"
				+ "<language>kor</language>\r\n" + "<person>출연 : 사샤 기트리,루시엥 바루,쟝 페리에,로저 보딘,로베르트 피자니</person>\r\n"
				+ "<publisher>KFAC04</publisher>\r\n" + "<regDate>2010-08-27T14:19:20+09:00</regDate>\r\n"
				+ "<rights>사샤 기트리</rights>\r\n" + "<rn>5</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26815제목 : Remontons les Champs-Elysees제작년도 : 1938영문명 : 제작국가 : 프랑스감독 : 사샤 기트리제작사 : Societe dExploitation et de Distribution de Films (SEDIF)영화심의여부 : 대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :24-NOV-10</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디,드라마</subjectCategory>\r\n"
				+ "<title>Remontons les Champs-Elysees</title>\r\n" + "<type>C01001</type>\r\n"
				+ "<uci>G706+KFAC04-C.movieInfo.F000026815</uci>\r\n" + " </item>\r\n" + "<item>\r\n"
				+ "<affiliation>Productions Emile Natan</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n" + "<contributor>각본:샤샤 기트리||배급사:</contributor>\r\n"
				+ "<createdDate>1938</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :</description>\r\n" + "<extent>상영시간 : 109</extent>\r\n"
				+ "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 사샤 기트리,가비 몰리,재클린 델루박,조르쥬 그레이,폴린느 카튼</person>\r\n" + "<publisher>KFAC04</publisher>\r\n"
				+ "<regDate>2010-08-27T14:24:45+09:00</regDate>\r\n" + "<rights>사샤 기트리</rights>\r\n" + "<rn>6</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26816제목 : Quadrille제작년도 : 1938영문명 : 제작국가 : 프랑스감독 : 사샤 기트리제작사 : Productions Emile Natan영화심의여부 : 대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :24-NOV-10</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디,멜로드라마</subjectCategory>\r\n" + "<title>Quadrille</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026816</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n" + "<affiliation>Cineas</affiliation>\r\n"
				+ "<alternativeTitle>The Story of a Cheat</alternativeTitle>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n" + "<contributor>각본:샤샤 기트리||배급사:</contributor>\r\n"
				+ "<createdDate>1936</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :12살 소년은 나쁜 짓을 한 죗값으로 저녁을 굶게 된다. 하필 그날 저녁 식사에서 소년을 제외한 11명의 가족은 독버섯이 든 음식을 먹고 모두 죽고 만다. 선의에 의한 행동이 처벌받는 반면 사기는 매번 좋은 결과를 낳자, 그는 자신의 운명을 따르기로 한다. 20년 동안 국적, 이름, 외모, 직업을 수없이 바꾸며 부를 축적한 한 사기꾼 삶의 이야기를 그린다. 프랑스의 유명한 시나리오 작가이자, 감독으로 잘 알려진 샤샤 기트리의 대표작으로 영화 전체를 이끌어가는 샤샤 기트리의 재치 있는 내레이션이 돋보인다.(서울아트시네마)</description>\r\n"
				+ "<extent>상영시간 : 81</extent>\r\n" + "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 사샤 기트리,마게리뜨 모레노,재클린 델루박,로저 듀체스네,로시네 데린,엘미르 보티에</person>\r\n"
				+ "<publisher>KFAC04</publisher>\r\n" + "<regDate>2010-08-27T11:06:09+09:00</regDate>\r\n"
				+ "<rights>사샤 기트리</rights>\r\n" + "<rn>7</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26812제목 : 어느 사기꾼의 이야기제작년도 : 1936영문명 : The Story of a Cheat제작국가 : 프랑스감독 : 사샤 기트리제작사 : Cineas영화심의여부 : 대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :21-FEB-19</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디</subjectCategory>\r\n" + "<title>어느 사기꾼의 이야기</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026812</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n" + "<affiliation>Films Sonores Tobis,Cineas</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n" + "<contributor>각본:샤샤 기트리||배급사:</contributor>\r\n"
				+ "<createdDate>1936</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :</description>\r\n" + "<extent>상영시간 : 81</extent>\r\n"
				+ "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 사샤 기트리,가스통 뒤보,세르쥐 그라베,폴 버나드,재클린 델루박,베티 다스몽드,폴린느 카튼</person>\r\n"
				+ "<publisher>KFAC04</publisher>\r\n" + "<regDate>2010-08-27T11:30:01+09:00</regDate>\r\n"
				+ "<rights>사샤 기트리</rights>\r\n" + "<rn>8</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 26813제목 : Mon pere avait raison제작년도 : 1936영문명 : 제작국가 : 프랑스감독 : 사샤 기트리제작사 : Films Sonores Tobis,Cineas영화심의여부 : 대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :24-NOV-10</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디</subjectCategory>\r\n" + "<title>Mon pere avait raison</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000026813</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n"
				+ "<affiliation>Les Films du Carrosse,Valoria Films,Fida Cinematografica</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n"
				+ "<contributor>각본:프랑소와 트뤼포,클로드 드 지브라이,베르나르 레본||배급사:</contributor>\r\n"
				+ "<createdDate>1970</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :프랑수와 트뤼포의 자기 반영적 캐릭터라 할 수 있는 ‘앙투안 드와넬’을 주인공으로 한 네 번째 작품. 스물여섯 살이 된 앙투안은 &lt;훔친 키스&gt;에서 만난 크리스틴과 결혼해 아들을 낳고 평범한 결혼 생활을 하고 있다. 전편에서도 여러 직업을 전전했던 앙투안은 플로리스트로 일하다 실패하고 선박 회사에 취직한다. 한편 선박 회사에 교코라는 일본 여성이 손님으로 방문하고, 앙투안은 교코의 신비로운 매력에 빠지게 되는데... Antoine Doinel a epouse Christine. Elle est bientot enceinte et Antoine, futur pere de famille, entre dans une importante entreprise americaine ou il fait la connaissance de Kyoko, une ravissante et jeune Japonaise dont il tombe follement amoureux...</description>\r\n"
				+ "<extent>상영시간 : 100</extent>\r\n" + "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 장 삐에르 레오,클로드 자드,히로코 베르그하우어,바바라 라지,다니엘 지라르,다니엘 세칼디,클레어 더헤이멜,다니엘 보랭거,자크 쥬아노,자크 리스팔,빌리 킨스,실바너 블레이지,피에르 마그엘론,마리안느 피켓티</person>\r\n"
				+ "<publisher>KFAC04</publisher>\r\n" + "<regDate>2008-05-07T13:37:13+09:00</regDate>\r\n"
				+ "<rights>프랑소와 트뤼포</rights>\r\n" + "<rn>9</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 21794제목 : 부부의 거처제작년도 : 1970영문명 : 제작국가 : 프랑스,이탈리아감독 : 프랑소와 트뤼포제작사 : Les Films du Carrosse,Valoria Films,Fida Cinematografica영화심의여부 : N대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :16-FEB-11</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디,드라마</subjectCategory>\r\n"
				+ "<subjectKeyword>연작, 부부, 바람</subjectKeyword>\r\n" + "<title>부부의 거처</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000021794</uci>\r\n" + " </item>\r\n"
				+ "<item>\r\n" + "<affiliation>Les Films du Carrosse</affiliation>\r\n"
				+ "<collectionDb>한국영상자료원 DB</collectionDb>\r\n"
				+ "<contributor>각본:프랑소와 트뤼포,마리 프란스 피지에,장 아우렐,수잔느 쉬프만배급사:</contributor>\r\n"
				+ "<createdDate>1979</createdDate>\r\n" + "<creator>한국영상자료원</creator>\r\n"
				+ "<description>줄거리 :프랑수와 트뤼포의 작품 세계를 관통하는 '앙투안 드와넬' 시리즈의 대미를 장식하는 작품. &lt;앙투안과 콜레트&gt;, &lt;훔친 키스&gt;, &lt;부부의 거처&gt; 속 장면을 영화 곳곳에서 볼 수 있다. &lt;400번의 구타&gt;에서 타자기를 훔쳐 달아났던 소년 앙투안은 소설가가 돼 옛 애인들과의 에피소드를 글로 옮기며 살아가고 있다. 여전히 철부지 같은 앙투안은 자신의 잘못은 깨닫지 못한 채 아내 크리스틴과 이혼하고 새로운 사랑에 빠진다. Les epoux Doinel divorcent par concentement mutuel. Comme beaucoup de jeunes divorces d'aujourd'hui, Antoine et Christine - devenue entre temps illustratrice de livres pour enfants - restent bons amis et c'est dans ses relations avec d'autres jeunes femmes qu'Antoine Doinel est amene a vivre d'autres conflits amoureux...</description>\r\n"
				+ "<extent>상영시간 : 94</extent>\r\n" + "<format>Video</format>\r\n" + "<grade>관리등급 :</grade>\r\n"
				+ "<insertDate>2020-09-21T13:21:24+09:00</insertDate>\r\n" + "<language>kor</language>\r\n"
				+ "<person>출연 : 장 삐에르 레오,마리 프란스 피지에,클로드 자드</person>\r\n" + "<publisher>KFAC04</publisher>\r\n"
				+ "<regDate>2008-05-07T13:53:05+09:00</regDate>\r\n" + "<rights>프랑소와 트뤼포</rights>\r\n"
				+ "<rn>10</rn>\r\n"
				+ "<subDescription>영화구분 : F영화등록번호 : 21795제목 : 사랑의 도피제작년도 : 1979영문명 : 제작국가 : 프랑스감독 : 프랑소와 트뤼포제작사 : Les Films du Carrosse영화심의여부 : N대표심의일 : 대표심의번호 : 대표개봉일 : 최종 업데이트일 :16-FEB-11</subDescription>\r\n"
				+ "<subjectCategory>장르 : 코메디,멜로드라마</subjectCategory>\r\n"
				+ "<subjectKeyword>연작, 소설가</subjectKeyword>\r\n" + "<title>사랑의 도피</title>\r\n"
				+ "<type>C01001</type>\r\n" + "<uci>G706+KFAC04-C.movieInfo.F000021795</uci>\r\n" + " </item>\r\n"
				+ " </items>\r\n" + "<numOfRows>10</numOfRows>\r\n" + "<pageNo>1</pageNo>\r\n"
				+ "<totalCount>371099</totalCount>\r\n" + " </body>\r\n" + " </response>";
		JSONObject jo = XML.toJSONObject(xml);
		ObjectMapper om = new ObjectMapper();
		System.out.println(jo.toString()); // json형식으로 바꾼모습, 범주가 더 큰게 키 작은게 벨류
		try {
//			 Map<Object, Object> map = om.readValue(jo.toString(), Map.class);
//			 System.out.println(map);

//		Body body = om.readValue(jo.toString(), Body.class); //body형태로 다시바꾸기
//		System.out.println(body);
			Result rs = om.readValue(jo.toString(), Result.class);
			Items items = rs.getResponse().getBody().getItems();
			List<Item> il = items.getItem();
			for (Item item : il) {
				System.out.println("제목:" + item.getTitle());
			}

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
