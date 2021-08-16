package heatflow_monitor;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import org.icepdf.ri.util.FontPropertiesManager;
import org.icepdf.ri.util.PropertiesManager;

import javax.swing.*;

/**
 * The <code>ViewerComponentExample</code> class is an example of how to use
 * <code>SwingController</code> and <code>SwingViewBuilder</code>
 * to build a PDF viewer component.  A file specified at the command line is
 * opened in a JFrame which contains the viewer component.
 *
 * @since 2.0
 */
public class PDFViewer {

    public static void view(String pdfFile) {

		/*
		// build a component controller
		SwingController controller = new SwingController();
		controller.setIsEmbeddedComponent(true);
 	
		// read stored system font properties.
  		FontPropertiesManager.getInstance().loadOrReadSystemFonts();
 	
		PropertiesManager properties = PropertiesManager.getInstance();
 	   	properties.getPreferences().putFloat(PropertiesManager.PROPERTY_DEFAULT_ZOOM_LEVEL, 1.25f);
	
		SwingViewBuilder factory = new SwingViewBuilder(controller, properties);
	
		// add interactive mouse link annotation support via callback
		controller.getDocumentViewController().setAnnotationCallback(
				new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
		JPanel viewerComponentPanel = factory.buildViewerPanel();
		JFrame applicationFrame = new JFrame();
		applicationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		applicationFrame.getContentPane().add(viewerComponentPanel);
		// Now that the GUI is all in place, we can try opening a PDF
		controller.openDocument(pdfFile);

		// add the window event callback to dispose the controller and
		// currently open document.
		applicationFrame.addWindowListener(controller);

		// show the component
		applicationFrame.pack();
		applicationFrame.setVisible(true);
		*/
		
		// build a component controller
        SwingController controller = new SwingController();
        
        // read stored system font properties.
  		// FontPropertiesManager.getInstance().loadOrReadSystemFonts();
 	

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();
        // applicationFrame.setDefaultCloseOperation(viewerComponentPanel.setVisible(false));
        applicationFrame.getContentPane().add(viewerComponentPanel);

        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(pdfFile);

        // show the component
        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }
}

/*
// build a component controller
        SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();
        // applicationFrame.setDefaultCloseOperation(viewerComponentPanel.setVisible(false));
        applicationFrame.getContentPane().add(viewerComponentPanel);

        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(pdfFile);

        // show the component
        applicationFrame.pack();
        applicationFrame.setVisible(true);
*/