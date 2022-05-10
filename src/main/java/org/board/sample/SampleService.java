package org.board.sample;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleDTO sampleDTO;

}
