import cv2
cv2.namedWindow("test")
cv2.namedWindow("test1")
cam = cv2.VideoCapture(0)
detector = cv2.CascadeClassifier("haarcascade_frontalface_alt.xml")
while True:
    temp , frame = cam.read()
    if not temp:
        break;
    faces = detector.detectMultiScale(frame)
    cv2.imshow("test1" , frame)
    for face in faces:
        a,b,c,d = face
        cv2.rectangle(frame , (a , b ) , (a+c , b+d) ,(0 , 255 , 0) , 3)
    cv2.imshow("test" , frame)
    val = cv2.waitKey(1)
    if val%256 == 27:
        # ESC button pressed
        break
cam.release()
cv2.destroyAllWindows()
