<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>
<body>
	<h1>CHART.js 라이브러리 실습</h1>
	
	
	<!--  -->
	<div>
		<h1>1)나라별 평균 나이</h1>
		<canvas id="chart1" style="width:100%;max-width:600px"></canvas>
	</div>
	
	<div>
		<h1>2)성별 가입자수</h1>
		<canvas id="chart2" style="width:100%;max-width:600px"></canvas>
	</div>
	
	<div>
		<h1>3)연도별 나라별 가입자수</h1>
		<canvas id="chart3" style="width:100%;max-width:600px"></canvas>
	</div>
	
	<div>
		<h1>4)연도별 누적 가입자 수</h1>
		<canvas id="chart4" style="width:100%;max-width:600px"></canvas>
	</div>
	
	
	
	<script>
		//chart4
		$.ajax({
		  url: '/rest/totalCountByYear',
		  type: 'post',
		  success: function(data) {
			    const xValues = [];
			    const yValues = [];
			  	// 데이터 넣기
			    $(data).each(function(i, e) {
			    	xValues.push(e.year);     
			    	yValues.push(e.sumCount); 
			    });

			    new Chart("chart4", {
			      type: "line",
			      data: {
			        labels: xValues,
			        datasets: [{
			        	label: "누적 가입자 수",
			          backgroundColor:"rgba(0,0,255,1.0)",
			          borderColor: "rgba(0,0,255,0.1)",
			          data: yValues,
			          fill: false
			        }]
			      },
			    })
			    }
		});
	
		// chart2
		$.ajax({
		  url: '/rest/countBygender',
		  type: 'post',
		  success: function(data) {
			  const xValues = [];
			  const yValues = [];
			    // 데이터 넣기
			    $(data).each(function(i, e) {
			      xValues.push(e.gender); 
			      yValues.push(e.count);  
			    });
			  
		new Chart("chart2", {
			  type: "pie",
			  data: {
			    labels: xValues,
			    datasets: [{
			      backgroundColor: ["blue","orange"],
			      data: yValues
			    }]
			  },
			  options: {
			    title: {
			      display: true,
			      text: ""
			    }
			  }
			})
			}
		});
	
		// chart3
		$.ajax({
		  url: '/rest/countByYearAndCountry',
		  type: 'post',
		  success: function(data) {
		    console.log(data);
		
		    const xValues = []; // 년도
		    const d0 = [];
		    const d1 = [];
		    const d2 = [];
		    const d3 = [];
		
		    $(data).each(function(i, e) {
		      if (i % 4 == 0) {
		        xValues.push(e.year);
		        d0.push(e.count);
		      } else if (i % 4 == 1) {
		        d1.push(e.count);
		      } else if (i % 4== 2) {
		        d2.push(e.count);
		      } else if (i % 4 == 3) {
		        d3.push(e.count);
		      }
		    });
		
		    new Chart("chart3", {
		      type: "line",
		      data: {
		        labels: xValues,
		        datasets: [
		          {
		            label:'독일',
		        	data: d0,
		            borderColor: "red",
		            fill: false
		          },
		          {
		        	  label:'미국',
		            data: d1,
		            borderColor: "green",
		            fill: false
		          },
		          {
		        	  label:'한국',
		            data: d2,
		            borderColor: "blue",
		            fill: false
		          },
		          {
		        	  label:'호주',
		            data: d3,
		            borderColor: "brown",
		            fill: false
		          }
		        ]
		      },
		      options: {
		        legend: { display: true }
		      }
		    });
		  }
		});
		// end chart3
						
	
		// chart1
		$.ajax({
			url : '/rest/avgAgeByCountry',
			type : 'post',
			success : function(data){
				console.log(data);
				// start chart1에 bar차트를 출력
				const xValues = []; // 나라
				const yValues = []; // 평균나이
				const barColors = ["green","blue","orange","brown"];
				
				$(data).each(function(i, e){
					xValues.push(e.country);
					yValues.push(e.age);
				});
				
				console.log(xValues);
				console.log(yValues);
				
				new Chart("chart1", {
				  type: "bar",
				  data: {
				    labels: xValues,
				    datasets: [{
				      backgroundColor: barColors,
				      data: yValues
				    }]
				  },
				  options: {
				    legend: {display: false},
				    scales: {
				      yAxes: [{
				        ticks: {
				          beginAtZero: true
				        }
				      }]
				    },
				
				    title: {
				      display: true,
				      text: ""
				    }
				  }
				});
			}
		});
	
	</script>
	
</body>
</html>