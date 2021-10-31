export * from './apiController.service';
import { ApiControllerService } from './apiController.service';
export * from './greetingControllerImpl.service';
import { GreetingControllerImplService } from './greetingControllerImpl.service';
export const APIS = [ApiControllerService, GreetingControllerImplService];
