#모듈import
import pygame
import math
#초기화
pygame.init()

#help 명령어로 메서드 설명 보기가 가능하다 help(pygame.init)

width, height = 1280, 760

#스크린 만들기
screen = pygame.display.set_mode((width, height))

#이미지를 불러와 오브젝트 생성
player = pygame.image.load("resources/images/dude.png")
grass = pygame.image.load("resources/images/grass.png")
castle = pygame.image.load("resources/images/castle.png")
arrow = pygame.image.load("resources/images/bullet.png")



keys = [False, False, False, False] #처음 키값.. 입력받을것들 WASD
playpos = [200,200] # 플레이어 위치 값이 바뀌면서 움직일수 있다..
# 경로 입력하는 부분을 모르겠다..


#화살 추가
acc = [0, 0]
arrows = [] # 화살 정보


while True:
    #화면 계속 띄우기
    screen.fill((0,0,0))

    #배경그리기 , # //는 소수점 버림..
    for x in range(width//grass.get_width()+1):
        for y in range(height//grass.get_height()+1):
          screen.blit(grass, (x*100, y*100))

    screen.blit(castle, (0, 50))
    screen.blit(castle, (0, 200))
    screen.blit(castle, (0, 350))
    screen.blit(castle, (0, 500))



    #플레이어 포지션 회전, https://opentutorials.org/course/3045/18395 두번째 강
    position = pygame.mouse.get_pos() #현재 마우스의 위치값 가져옴..
    angle = math.atan2(position[1]-(playpos[1]+32), position[0]- (playpos[0]+26))
    playerrot = pygame.transform.rotate(player, 360-angle*57.29) # 로테이션. 객체를 각도만큼 회전시켜주는 함수
    playerpos1 = (playpos[0] - playerrot.get_rect().width//2, playpos[1] - playerrot.get_rect().height//2)
    screen.blit(playerrot, playerpos1)


    #화살 그리기
    for bullet in arrows:
        index = 0
        velx = math.cos(bullet[0]) * 10
        vely = math.sin(bullet[0]) * 10
        bullet[1] = bullet[1] + velx
        bullet[2] = bullet[2] + vely
        if bullet[1] < -64 or bullet[1] > 640 or bullet[2] < -64 or bullet[2] > 480:
            arrows.pop(index)
        index = index + 1
        for projectile in arrows:
            arrow1 = pygame.transform.rotate(arrow, 360 - projectile[0] * 57.29)
            screen.blit(arrow1, (projectile[1], projectile[2]))






    #화면 다시 그리기 flip은 화면 전체 업데이트
    pygame.display.flip()

    #게임 종료
    for event in pygame.event.get():  #이벤트 발생하면 아
        # 화면에 X 눌렀을때 꺼지게
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)


        if event.type == pygame.KEYDOWN: # 키가 눌렸을때..
            if event.key == pygame.K_w:
                keys[0] = True
            elif event.key == pygame.K_a:
                keys[1] = True
            elif event.key == pygame.K_s:
                keys[2] = True
            elif event.key == pygame.K_d:
                keys[3] = True


        if event.type == pygame.KEYUP: # 키가 눌렸을때..
            if event.key == pygame.K_w:
                keys[0] = False
            elif event.key == pygame.K_a:
                keys[1] = False
            elif event.key == pygame.K_s:
                keys[2] = False
            elif event.key == pygame.K_d:
                keys[3] = False



        #player 움직이기
        if keys[0] == True:
            playpos[1] = playpos[1] - 10 #위로 올라감
        elif keys[2] == True:
            playpos[1] = playpos[1] + 10 #아래로 내려감
        elif keys[1] == True:
            playpos[0] = playpos[0] - 10 # 왼쪽이동
        elif keys[3] == True:
            playpos[0] = playpos[0] + 10 #오른


        if event.type == pygame.MOUSEBUTTONDOWN:
            position = pygame.mouse.get_pos() # 현재 마우스의 위치값을 찾아 position에 대입
            acc[1] = acc[1] +1
            arrows.append([math.atan2(position[1] - (playerpos1[1] + 32), \
                            position[0] - (playerpos1[0] + 26)), playerpos1[0] + 32, \
                           playerpos1[1] + 32])
