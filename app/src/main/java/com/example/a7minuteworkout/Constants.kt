package com.example.a7minuteworkout

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

        val exerciseAbdominalCrunch = ExerciseModel(
            2,
            "Abdominal Crunch",
            R.drawable.ic_abdominal_crunch,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseAbdominalCrunch)

        val exerciseHighKneesRunning = ExerciseModel(
            3,
            "High Knee Running",
            R.drawable.ic_high_knees_running_in_place,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseHighKneesRunning)

        val exerciseLunge = ExerciseModel(
            4,
            "lunge",
            R.drawable.ic_lunge,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseLunge)

        val exercisePlank = ExerciseModel(
            5,
            "plank",
            R.drawable.ic_plank,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exercisePlank)

        val exercisePushUp = ExerciseModel(
            6,
            "Push Up",
            R.drawable.ic_push_up,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exercisePushUp)

        val exercisePushUpandRotation = ExerciseModel(
            7,
            "Push up and Rotation",
            R.drawable.ic_push_up_and_rotation,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exercisePushUpandRotation)

        val exerciseSidePlank = ExerciseModel(
            8,
            "Side plank",
            R.drawable.ic_side_plank,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseSidePlank)

        val exerciseSquart = ExerciseModel(
            9,
            "Squart",
            R.drawable.ic_squat,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseSquart)

        val exerciseStepUpOnChair = ExerciseModel(
            10,
            "Step Up On Chair",
            R.drawable.ic_step_up_onto_chair,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseStepUpOnChair)

        val exerciseTricepsDip = ExerciseModel(
            11,
            "Triceps Dip",
            R.drawable.ic_triceps_dip_on_chair,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseTricepsDip)

        val exerciseWallSit = ExerciseModel(
            12,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(exerciseWallSit)


        return exerciseList
    }
}