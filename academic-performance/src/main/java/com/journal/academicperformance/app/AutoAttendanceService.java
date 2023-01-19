package com.journal.academicperformance.app;

import com.journal.academicperformance.domain.Result;
import com.journal.academicperformance.domain.ResultType;

import com.journal.academicperformance.adapters.database.ResultRepository;
import lombok.NonNull;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AutoAttendanceService {

    private static final String AUTO_ATTENDANCE_MARK = "PRESENT";
    private static final String AUTO_ATTENDANCE_VALUE = "1";

    private final ResultRepository resultRepository;

    public AutoAttendanceService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }


    public void onMessage(@NonNull String lessonId, @NonNull String personId, String attendanceValue){
        Result existedResult = resultRepository.findByLessonIdAndPersonIdAndResultType(
                lessonId,
                personId,
                ResultType.AUTO_ATTENDANCE );

        if(existedResult == null && AUTO_ATTENDANCE_MARK.equals(attendanceValue)){
            Result newResult = new Result( lessonId, personId, ResultType.AUTO_ATTENDANCE);
            newResult.setValue(AUTO_ATTENDANCE_VALUE);
            resultRepository.save(newResult);
        } else if(existedResult != null) {
            if( ! AUTO_ATTENDANCE_MARK.equals(attendanceValue)){
                resultRepository.delete(existedResult);
            }
        }
    }
}
