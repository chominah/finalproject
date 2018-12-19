<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div id="wrap">
<section class=" kt-pt-180">
        <div class="container">
            <div class="row" ng-app="app" ng-controller="calendarCtrl">
                <input type="hidden" ng-init="courseType='WORKTRAINEE'" value="WORKTRAINEE" ng-model="courseType" ng-value="courseType">
                <div class="col-md-3">
                    <div class="hpanel panel-group">
                        <div class="panel-body">
                            <span class="label label-default">Today</span>
                            <h4 class="font-light">
                                2018.12.14 (금요일)
                            </h4>
                            <h5><i class="fa fa-info-circle"></i> 주제를 누르면 주제별 과정이 달력에 표시됩니다.<h5>
                        </div>
                        
                        <div class="panel-body">
                            <h5>재직자 과정 주제</h5>
                            <ul class="topicBox-list">
                                
                                    <li>
                                        <span ng-class="{active:topicId == '4'}" ng-click="changeTopic(4)" >
                                            <i class="fa fa-square" style="color: #AA12B2;"></i> 경영/비즈니스
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '5'}" ng-click="changeTopic(5)" >
                                            <i class="fa fa-square" style="color: #AA4319;"></i> 컨설팅/EA
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '22'}" ng-click="changeTopic(22)" >
                                            <i class="fa fa-square" style="color: #E3F3EB;"></i> SW공학
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '23'}" ng-click="changeTopic(23)" >
                                            <i class="fa fa-square" style="color: #48B4EC;"></i> 비즈니스 분석(BA)
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '32'}" ng-click="changeTopic(32)" >
                                            <i class="fa fa-square" style="color: #ACF2E6;"></i> SOA	
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '8'}" ng-click="changeTopic(8)" >
                                            <i class="fa fa-square" style="color: #244B43;"></i> 설계
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '10'}" ng-click="changeTopic(10)" >
                                            <i class="fa fa-square" style="color: #82A943;"></i> DB
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '11'}" ng-click="changeTopic(11)" >
                                            <i class="fa fa-square" style="color: #216C93;"></i> 프로그래밍
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '21'}" ng-click="changeTopic(21)" >
                                            <i class="fa fa-square" style="color: #0A5CBD;"></i> 모바일
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '26'}" ng-click="changeTopic(26)" >
                                            <i class="fa fa-square" style="color: #C4B85B;"></i> 임베디드
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '25'}" ng-click="changeTopic(25)" >
                                            <i class="fa fa-square" style="color: #177D37;"></i> IoT
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '15'}" ng-click="changeTopic(15)" >
                                            <i class="fa fa-square" style="color: #6B14ED;"></i> 클라우드
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '19'}" ng-click="changeTopic(19)" >
                                            <i class="fa fa-square" style="color: #18D48C;"></i> 빅데이터
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '27'}" ng-click="changeTopic(27)" >
                                            <i class="fa fa-square" style="color: #8D7734;"></i> 리눅스
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '14'}" ng-click="changeTopic(14)" >
                                            <i class="fa fa-square" style="color: #32FFDE;"></i> 인공지능(AI)
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '9'}" ng-click="changeTopic(9)" >
                                            <i class="fa fa-square" style="color: #B31B41;"></i> SW테스트
                                        </span>
                                    </li>
                                
                                    <li>
                                        <span ng-class="{active:topicId == '20'}" ng-click="changeTopic(20)" >
                                            <i class="fa fa-square" style="color: #866C46;"></i> SW안전/보안
                                        </span>
                                    </li>
                                
                            </ul>
                        </div>
                        
                    </div>
                </div>
                <div class="col-md-9 kt-pt-20">
                    <a class="btn w-xs  btn-primary" href="/lectures/cal?courseType=WORKTRAINEE">재직자 과정</a>  <a class="btn w-xs  btn-default" href="/lectures/cal?courseType=TRAINEE">채용예정자 과정</a>

                    <div class="hpanel kt-pt-40">
                        <div ui-calendar="uiConfig.calendar" ng-model="eventSources" calendar="myCalendar" ></div>
                    </div>
                </div>
            </div>
		</div>
	</section>
</div>